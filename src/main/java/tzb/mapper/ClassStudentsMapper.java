package tzb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tzb.pojo.ClassStudents;

import java.util.List;

@Mapper
public interface ClassStudentsMapper {
    @Insert("insert into class_students values(#{classId}, #{studentId})")
    Integer insert(ClassStudents classStudents);
    @Select("select * from class_students where class_Id = #{classId}")
    List<ClassStudents> selectByClassId(long classId);
}
