package tzb.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import tzb.mapper.ConfigMapper;
import tzb.pojo.Config;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类，支持上传图片/视频到指定目录
 */
@Component
public class OssUtil {

    @Autowired
    private ConfigMapper configMapper;

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    // 支持的图片和视频格式
    private static final String[] IMAGE_TYPES = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
    private static final String[] VIDEO_TYPES = {".mp4", ".avi", ".mov", ".wmv", ".flv"};

    @PostConstruct
    public void initConfig() {
        List<Config> configs = configMapper.getAllConfigs();
        Map<String, String> configMap = new HashMap<>();
        for (Config c : configs) {
            configMap.put(c.getConfigKey(), c.getConfigValue());
        }

        this.endpoint = configMap.get("oss.endpoint");
        this.accessKeyId = configMap.get("oss.accessKeyId");
        this.accessKeySecret = configMap.get("oss.accessKeySecret");
        this.bucketName = configMap.get("oss.bucketName");
    }

    /**
     * 上传文件（图片或视频）到指定目录
     * @param file 上传的文件（MultipartFile）
     * @param prefix 目标目录（如 "images/" 或 "videos/"）
     * @return 上传后的文件路径（OSS 中的完整 key）
     * @throws IllegalArgumentException 如果文件类型不支持或为空
     * @throws IOException 如果上传过程中发生 IO 异常
     */
    public String uploadFile(MultipartFile file, String prefix) throws IOException {
        // 参数校验
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("上传文件不能为空");
        }

        // 获取文件名并校验文件类型
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !isSupportedFile(originalFilename)) {
            throw new IllegalArgumentException("不支持的文件类型，仅支持图片（jpg/jpeg/png/gif/bmp）和视频（mp4/avi/mov/wmv/flv）");
        }

//        // 构造 OSS 存储路径
//        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String fileName = UUID.randomUUID().toString() + fileExtension;  // 使用 UUID 避免文件名冲突
//        String ossKey = (prefix.endsWith("/") ? prefix : prefix + "/") + fileName;
        // 构造 OSS 存储路径，使用原始文件名
        String ossKey = (prefix.endsWith("/") ? prefix : prefix + "/") + originalFilename;

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 上传文件
            try (InputStream inputStream = file.getInputStream()) {
                ossClient.putObject(bucketName, ossKey, inputStream);
            }
            return ossKey;
        } catch (OSSException e) {
            throw new RuntimeException("OSS 上传失败: " + e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 检查文件类型是否支持
     * @param fileName 文件名
     * @return 是否支持
     */
    private boolean isSupportedFile(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        for (String imageType : IMAGE_TYPES) {
            if (fileExtension.equals(imageType)) {
                return true;
            }
        }
        for (String videoType : VIDEO_TYPES) {
            if (fileExtension.equals(videoType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取文件的访问 URL
     * @param ossKey OSS 中的文件 key
     * @return 文件的访问 URL
     */
    public String getFileUrl(String ossKey) {
        return String.format("https://%s.%s/%s", bucketName, endpoint, ossKey);
    }

    /**
     * 获取 e_learning 下的一级子文件夹数组
     * @return 子文件夹名称数组
     */
    public List<String> listFolders() {
        List<String> folders = new ArrayList<>();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 设置请求参数，列出 e_learning/ 下的子文件夹
            ListObjectsRequest request = new ListObjectsRequest(bucketName);
            request.setPrefix("e_learning/"); // 限制前缀为 e_learning/
            request.setDelimiter("/"); // 使用 / 分隔符，仅返回子文件夹

            ObjectListing listing = ossClient.listObjects(request);
            // 获取子文件夹（getCommonPrefixes 返回 String 类型的文件夹路径）
            for (String prefix : listing.getCommonPrefixes()) {
                folders.add(prefix);
            }
            return folders;
        } catch (OSSException e) {
            throw new RuntimeException("获取文件夹列表失败: " + e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 列出指定前缀下的文件列表
     * @param prefix 目标前缀（如 "e_learning/3分钟小故事/"）
     * @return 文件路径列表（OSS 中的完整 key）
     */
    public List<String> listFiles(String prefix) {
        List<String> files = new ArrayList<>();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 设置请求参数，列出指定前缀下的文件
            ListObjectsRequest request = new ListObjectsRequest(bucketName);
            request.setPrefix(prefix); // 限制前缀
            request.setDelimiter("/"); // 使用 / 分隔符，避免递归列出子文件夹内容

            ObjectListing listing = ossClient.listObjects(request);
            // 获取文件列表
            for (OSSObjectSummary object : listing.getObjectSummaries()) {
                String key = object.getKey();
                // 排除文件夹（以 / 结尾的 key）和前缀本身
                if (!key.endsWith("/") && !key.equals(prefix)) {
                    files.add(key);
                }
            }
            return files;
        } catch (OSSException e) {
            throw new RuntimeException("获取文件列表失败: " + e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}