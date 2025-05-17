package tzb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tzb.pojo.ClassTeachers;

import java.util.List;

@Mapper 
public interface ClassTeachersMapper {
    @Insert("insert into class_teachers values(#{classId}, #{teacherId})")
    Integer insert(ClassTeachers classteachers);
    @Select("select * from class_teachers where class_Id = #{classId}")
    List<ClassTeachers> selectByClassId(long classId);
}
