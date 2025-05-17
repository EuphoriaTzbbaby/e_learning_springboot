// Controller - Insert
package tzb.controller.VideoAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.VideoAlbum;
import tzb.service.VideoAlbumService;

@RestController
@RequestMapping("/videoAlbum/insert")
public class VideoAlbumInsertController {

    @Autowired
    private VideoAlbumService service;

    @PostMapping
    public boolean insert(@RequestBody VideoAlbum album) {
        return service.insert(album);
    }
}