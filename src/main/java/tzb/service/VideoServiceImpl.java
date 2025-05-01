package tzb.service;

import tzb.mapper.VideoMapper;
import tzb.pojo.Video;
import tzb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video getById(long id) {
        return videoMapper.selectById(id);
    }

    @Override
    public List<Video> selectByAlbumId(long id) {
        return videoMapper.selectByAlbumId(id);
    }
    @Override
    public List<Video> getAll() {
        return videoMapper.selectAll();
    }

    @Override
    public int add(Video video) {
        return videoMapper.insert(video);
    }

    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int delete(long id) {
        return videoMapper.delete(id);
    }
}