// Controller - Update
package tzb.controller.VideoAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.VideoAlbum;
import tzb.service.VideoAlbumService;

@RestController
@RequestMapping("/videoAlbum/update")
public class VideoAlbumUpdateController {

    @Autowired
    private VideoAlbumService service;

    @PutMapping
    public boolean update(@RequestBody VideoAlbum album) {
        return service.update(album);
    }
}