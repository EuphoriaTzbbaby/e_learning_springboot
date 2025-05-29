package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.CourseNotice;

import java.util.List;

@Mapper
public interface CourseNoticeMapper {

    @Insert("INSERT INTO course_notice(course_id, teacher_id, title, content, create_time) " +
            "VALUES(#{courseId}, #{teacherId}, #{title}, #{content}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(CourseNotice notice);

    @Delete("DELETE FROM course_notice WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE course_notice SET course_id = #{courseId}, teacher_id = #{teacherId}, title = #{title}, " +
            "content = #{content}, create_time = #{createTime} WHERE id = #{id}")
    int update(CourseNotice notice);

    @Select("SELECT * FROM course_notice WHERE id = #{id}")
    CourseNotice findById(long id);

    @Select("SELECT * FROM course_notice ORDER BY create_time DESC")
    List<CourseNotice> findAll();
}
