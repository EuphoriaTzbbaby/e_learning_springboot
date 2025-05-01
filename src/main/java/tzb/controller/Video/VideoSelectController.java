
// VideoSelectController.java
package tzb.controller.Video;

import tzb.pojo.Video;
import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video/select")
public class VideoSelectController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/{id}")
    public Video getById(@PathVariable long id) {
        return videoService.getById(id);
    }
    @GetMapping("/byAlbumId/{id}")
    public List<Video> getByAlbumId(@PathVariable long id) {
        return videoService.selectByAlbumId(id);
    }

    @GetMapping("/all")
    public List<Video> getAll() {
        return videoService.getAll();
    }
}