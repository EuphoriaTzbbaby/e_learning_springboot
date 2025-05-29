package tzb.service;

import tzb.pojo.CourseNotice;

import java.util.List;

public interface CourseNoticeService {

    int addNotice(CourseNotice notice);

    int deleteNotice(long id);

    int updateNotice(CourseNotice notice);

    CourseNotice getNoticeById(long id);

    List<CourseNotice> getAllNotices();
}
