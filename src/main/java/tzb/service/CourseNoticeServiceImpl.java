package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.CourseNoticeMapper;
import tzb.pojo.CourseNotice;
import tzb.service.CourseNoticeService;

import java.util.List;

@Service
public class CourseNoticeServiceImpl implements CourseNoticeService {

    @Autowired
    private CourseNoticeMapper mapper;

    @Override
    public int addNotice(CourseNotice notice) {
        return mapper.insert(notice);
    }

    @Override
    public int deleteNotice(long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateNotice(CourseNotice notice) {
        return mapper.update(notice);
    }

    @Override
    public CourseNotice getNoticeById(long id) {
        return mapper.findById(id);
    }

    @Override
    public List<CourseNotice> getAllNotices() {
        return mapper.findAll();
    }
}
