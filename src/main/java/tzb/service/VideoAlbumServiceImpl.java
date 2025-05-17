package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.VideoAlbumMapper;
import tzb.pojo.VideoAlbum;
import tzb.service.VideoAlbumService;

import java.util.List;

@Service
public class VideoAlbumServiceImpl implements VideoAlbumService {

    @Autowired
    private VideoAlbumMapper mapper;

    public List<VideoAlbum> getAll() {
        return mapper.selectAll();
    }

    public VideoAlbum getById(long id) {
        return mapper.selectById(id);
    }

    public boolean insert(VideoAlbum album) {
        return mapper.insert(album) > 0;
    }

    public boolean delete(long id) {
        return mapper.deleteById(id) > 0;
    }

    public boolean update(VideoAlbum album) {
        return mapper.update(album) > 0;
    }
}