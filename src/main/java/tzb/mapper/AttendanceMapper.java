package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Attendance;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    @Insert("INSERT INTO attendance(class_id, student_id, course_id, status, record_date, created_at) " +
            "VALUES(#{classId}, #{studentId}, #{courseId}, #{status}, #{recordDate}, #{createdAt})")
    int insert(Attendance attendance);

    @Delete("DELETE FROM attendance WHERE id = #{id}")
    int deleteById(long id);

    @Select("SELECT * FROM attendance WHERE id = #{id}")
    Attendance selectById(long id);

    @Select("SELECT * FROM attendance")
    List<Attendance> selectAll();

    @Update("UPDATE attendance SET class_id=#{classId}, student_id=#{studentId}, course_id=#{courseId}, " +
            "status=#{status}, record_date=#{recordDate}, created_at=#{createdAt} WHERE id = #{id}")
    int update(Attendance attendance);
}
