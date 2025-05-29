// Controller - Select
package tzb.controller.VideoAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.VideoAlbum;
import tzb.service.VideoAlbumService;
import tzb.utils.Match;

import java.util.ArrayList;
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
    @GetMapping("/selectBySelectVal/{selectVal}")
    public List<VideoAlbum> getBySelectVal(@PathVariable String selectVal) {
        List<VideoAlbum> list = service.getAll();
        List<VideoAlbum> result = new ArrayList<>();
        Match match = new Match();
        for(VideoAlbum videoAlbum : list){
            if(match.checkContainSubsequence(selectVal, videoAlbum.getCoverUrl())) {
                result.add(videoAlbum);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, videoAlbum.getTitle())) {
                result.add(videoAlbum);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, videoAlbum.getDescription())) {
                result.add(videoAlbum);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(videoAlbum.getCreateTime()))) {
                result.add(videoAlbum);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(videoAlbum.getId()))) {
                result.add(videoAlbum);
            }
        }
        return result;
    }
}