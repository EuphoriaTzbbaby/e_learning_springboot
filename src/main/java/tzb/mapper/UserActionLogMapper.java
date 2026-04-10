package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.UserActionLog;

import java.util.List;

@Mapper
public interface UserActionLogMapper {

    // 新增
    @Insert("""
        INSERT INTO user_action_log(user_id, action_type, action_content, action_time)
        VALUES(#{userId}, #{actionType}, #{actionContent}, NOW())
    """)
    int insert(UserActionLog log);

    // 删除
    @Delete("DELETE FROM user_action_log WHERE id = #{id}")
    int deleteById(Long id);

    // 批量删除用户日志
    @Delete("DELETE FROM user_action_log WHERE user_id = #{userId}")
    int deleteByUserId(Long userId);

    // 查询单条
    @Select("SELECT * FROM user_action_log WHERE id = #{id}")
    UserActionLog selectById(Long id);

    // 查询全部
    @Select("SELECT * FROM user_action_log ORDER BY action_time DESC")
    List<UserActionLog> selectAll();

    // 按用户查询
    @Select("SELECT * FROM user_action_log WHERE user_id = #{userId} ORDER BY action_time DESC")
    List<UserActionLog> selectByUserId(Long userId);

    // 按类型查询
    @Select("SELECT * FROM user_action_log WHERE action_type = #{actionType} ORDER BY action_time DESC")
    List<UserActionLog> selectByType(String actionType);

    // 分页查询
    @Select("""
        SELECT * FROM user_action_log
        ORDER BY action_time DESC
        LIMIT #{offset}, #{size}
    """)
    List<UserActionLog> selectPage(@Param("offset") int offset,
                                   @Param("size") int size);

    // 统计数量
    @Select("SELECT COUNT(*) FROM user_action_log")
    int countAll();
}