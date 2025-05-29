
// VideoSelectController.java
package tzb.controller.Video;

import tzb.pojo.Video;
import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.utils.Match;

import java.util.ArrayList;
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
    @GetMapping("/selectBySelectVal/{selectVal}")
    public List<Video> getBySelectVal(@PathVariable String selectVal) {
        List<Video> list = videoService.getAll();
        List<Video> result = new ArrayList<>();
        Match match = new Match();
        for (Video video : list) {
            if(match.checkContainSubsequence(selectVal, video.getVideoUrl())) {
                result.add(video);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, video.getOssKey())) {
                result.add(video);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, video.getTitle())) {
                result.add(video);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(video.getId()))) {
                result.add(video);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(video.getAlbumId()))) {
                result.add(video);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(video.getDuration()))) {
                result.add(video);
            }
        }
        return result;
    }
}