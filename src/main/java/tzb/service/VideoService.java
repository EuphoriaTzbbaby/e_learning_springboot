package tzb.service;

import tzb.pojo.Video;
import java.util.List;

public interface VideoService {
    Video getById(long id);
    List<Video> getAll();
    List<Video> selectByAlbumId(long id);
    int add(Video video);
    int update(Video video);
    int delete(long id);
}
