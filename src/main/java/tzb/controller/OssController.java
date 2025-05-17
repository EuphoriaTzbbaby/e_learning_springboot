package tzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tzb.utils.OssUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/oss")
public class OssController {

    @Autowired
    private OssUtil ossUtil;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file,
                                      @RequestParam("prefix") String prefix) {
        Map<String, Object> result = new HashMap<>();
        try {
            String ossKey = ossUtil.uploadFile(file, prefix);
            String fileUrl = ossUtil.getFileUrl(ossKey);
            result.put("success", true);
            result.put("url", fileUrl);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/folders")
    public Map<String, Object> getFolders() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<String> folders = ossUtil.listFolders();
            result.put("success", true);
            result.put("folders", folders);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    @GetMapping("/videos")
    public List<String> getVideoList(@RequestParam(defaultValue = "e_learning/3分钟小故事/") String prefix) {
        System.out.println("getVideoList");
        return ossUtil.listFiles(prefix);
    }
}