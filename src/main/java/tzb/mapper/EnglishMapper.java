package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.English;

import java.util.List;

@Mapper
public interface EnglishMapper {

    @Insert("INSERT INTO english(userId, content, coreKey, translation, comment, createDate, updateDate, isDeleted, status, isTaboo, textCnt) " +
            "VALUES(#{userId}, #{content}, #{coreKey}, #{translation}, #{comment}, #{createDate}, #{updateDate}, #{isDeleted}, #{status}, #{isTaboo}, #{textCnt})")
    @Options(useGeneratedKeys = true, keyProperty = "egId")
    int insert(English english);

    @Delete("DELETE FROM english WHERE egId = #{egId}")
    int deleteById(@Param("egId") long egId);

    @Update("UPDATE english SET userId = #{userId}, content = #{content}, coreKey = #{coreKey}, translation = #{translation}, comment = #{comment},  isTaboo = #{isTaboo}, textCnt = #{textCnt}, " +
            "updateDate = #{updateDate}, isDeleted = #{isDeleted}, status = #{status} WHERE egId = #{egId}")
    int update(English english);

    @Select("SELECT * FROM english WHERE egId = #{egId}")
    English selectById(@Param("egId") long egId);

    @Select("SELECT * FROM english WHERE isDeleted = 0")
    List<English> selectAll();
}
