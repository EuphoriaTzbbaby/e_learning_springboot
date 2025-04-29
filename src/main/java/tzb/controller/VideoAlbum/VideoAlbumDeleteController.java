// Controller - Delete
package tzb.controller.VideoAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.VideoAlbumService;

@RestController
@RequestMapping("/videoAlbum/delete")
public class VideoAlbumDeleteController {

    @Autowired
    private VideoAlbumService service;

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }
}