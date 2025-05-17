
// VideoUpdateController.java
package tzb.controller.Video;

import tzb.pojo.Video;
import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoUpdateController {

    @Autowired
    private VideoService videoService;

    @PutMapping("/update")
    public int update(@RequestBody Video video) {
        return videoService.update(video);
    }
}