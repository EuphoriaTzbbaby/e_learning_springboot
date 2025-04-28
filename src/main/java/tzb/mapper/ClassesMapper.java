package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Classes;

import java.util.List;

@Mapper
public interface ClassesMapper {

    @Select("SELECT * FROM classes WHERE id = #{id}")
    Classes selectById(@Param("id") long id);

    @Select("SELECT * FROM classes")
    List<Classes> selectAll();

    @Insert("INSERT INTO classes (name, created_at) " +
            "VALUES (#{name}, #{createdAt})")
    int insert(Classes classe);

    @Update("UPDATE classes SET name = #{name}, created_at = #{createdAt} WHERE id = #{id}")
    int updateById(Classes classe);

    @Delete("DELETE FROM classes WHERE id = #{id}")
    int deleteById(@Param("id") long id);
}
