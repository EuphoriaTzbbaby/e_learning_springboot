// VideoInsertController.java
package tzb.controller.Video;

import tzb.pojo.Video;
import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoInsertController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/insert")
    public int add(@RequestBody Video video) {
        System.out.println(video);
        return videoService.add(video);
    }
}