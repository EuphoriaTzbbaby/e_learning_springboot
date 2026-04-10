package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.GameRecord;

import java.util.List;

@Mapper
public interface GameRecordMapper {

    // 新增
    @Insert("INSERT INTO game_record(user_id, create_time, difficulty, result) " +
            "VALUES(#{userId}, #{createTime}, #{difficulty}, #{result})")
    @Options(useGeneratedKeys = true, keyProperty = "recordId")
    int insert(GameRecord gameRecord);

    // 查询单个
    @Select("SELECT * FROM game_record WHERE record_id = #{recordId}")
    GameRecord selectById(@Param("recordId") Long recordId);

    // 查询列表
    @Select("SELECT * FROM game_record ORDER BY create_time DESC")
    List<GameRecord> selectAll();

    // 根据用户查询列表
    @Select("SELECT * FROM game_record WHERE user_id = #{userId} ORDER BY create_time DESC")
    List<GameRecord> selectByUserId(@Param("userId") Long userId);

    // 更新
    @Update("UPDATE game_record SET difficulty=#{difficulty}, result=#{result} WHERE record_id=#{recordId}")
    int update(GameRecord gameRecord);

    // 删除
    @Delete("DELETE FROM game_record WHERE record_id = #{recordId}")
    int delete(@Param("recordId") Long recordId);
}