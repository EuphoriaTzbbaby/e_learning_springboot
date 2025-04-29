// VideoDeleteController.java
package tzb.controller.Video;

import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoDeleteController {

    @Autowired
    private VideoService videoService;

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable long id) {
        return videoService.delete(id);
    }
}
