// Controller - Select
package tzb.controller.VideoAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.VideoAlbum;
import tzb.service.VideoAlbumService;

import java.util.List;

@RestController
@RequestMapping("/videoAlbum/select")
public class VideoAlbumSelectController {

    @Autowired
    private VideoAlbumService service;

    @GetMapping("/all")
    public List<VideoAlbum> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VideoAlbum getById(@PathVariable long id) {
        return service.getById(id);
    }
}