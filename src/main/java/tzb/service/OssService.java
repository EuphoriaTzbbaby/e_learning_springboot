package tzb.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.OSSObjectSummary;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ConfigMapper;
import tzb.pojo.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OssService {
    @Autowired
    private ConfigMapper configMapper;

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public OssService(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    @PostConstruct
    public void initConfig() {
        List<Config> configs = configMapper.getAllConfigs();
        Map<String, String> configMap = new HashMap<>();
        System.out.println(configs.size());
        System.out.println(666);
        for (Config c : configs) {
            configMap.put(c.getConfigKey(), c.getConfigValue());
//            System.out.println(c.getConfigKey());
//            System.out.println(c.getConfigValue());
        }
//
        this.endpoint = configMap.get("oss.endpoint");
        this.accessKeyId = configMap.get("oss.accessKeyId");
        this.accessKeySecret = configMap.get("oss.accessKeySecret");
        this.bucketName = configMap.get("oss.bucketName");
    }

    public List<String> listFiles(String prefix) {
        List<String> fileNames = new ArrayList<>();

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ObjectListing objectListing = ossClient.listObjects(bucketName, prefix);

            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                String key = objectSummary.getKey();
                if (!key.endsWith("/")) {
                    fileNames.add(key);
                }
            }
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return fileNames;
    }
}
