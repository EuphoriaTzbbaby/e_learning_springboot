// Service 接口
package tzb.service;

import tzb.pojo.VideoAlbum;
import java.util.List;

public interface VideoAlbumService {
    List<VideoAlbum> getAll();
    VideoAlbum getById(long id);
    boolean insert(VideoAlbum album);
    boolean delete(long id);
    boolean update(VideoAlbum album);
}
