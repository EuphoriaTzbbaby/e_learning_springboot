package tzb.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin // 允许跨域请求，如果你前后端分离部署，这个注解很重要
public class OssVideo {

    private final tzb.service.OssService ossService;

    public OssVideo(tzb.service.OssService ossService) {
        this.ossService = ossService;
    }

    @GetMapping("/api/videos")
    public List<String> getVideoList(@RequestParam(defaultValue = "e_learning/3分钟小故事/") String prefix) {
        System.out.println("getVideoList");
        return ossService.listFiles(prefix);
    }
}
