package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.UserVideoAction;

import java.util.List;

@Mapper
public interface UserVideoActionMapper {

    // ================== 基础 ==================

    @Insert("""
        INSERT INTO video_action (user_id, video_id, action_type, state, create_time, update_time)
        VALUES (#{userId}, #{videoId}, #{actionType}, #{state}, NOW(), NOW())
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserVideoAction action);

    @Update("""
        UPDATE video_action
        SET state = #{state}, update_time = NOW()
        WHERE user_id = #{userId}
          AND video_id = #{videoId}
          AND action_type = #{actionType}
    """)
    int updateState(@Param("userId") Long userId,
                    @Param("videoId") Integer videoId,
                    @Param("actionType") Integer actionType,
                    @Param("state") Integer state);

    @Select("""
        SELECT * FROM video_action
        WHERE user_id = #{userId}
          AND video_id = #{videoId}
          AND action_type = #{actionType}
        LIMIT 1
    """)
    UserVideoAction selectOne(@Param("userId") Long userId,
                              @Param("videoId") Integer videoId,
                              @Param("actionType") Integer actionType);

    // ================== 核心：Upsert（推荐🔥） ==================

    /**
     * 有就更新，没有就插入（必须有唯一索引）
     */
    @Insert("""
        INSERT INTO video_action (user_id, video_id, action_type, state, create_time, update_time)
        VALUES (#{userId}, #{videoId}, #{actionType}, #{state}, NOW(), NOW())
        ON DUPLICATE KEY UPDATE
            state = VALUES(state),
            update_time = NOW()
    """)
    int saveOrUpdate(UserVideoAction action);

    // ================== 查询状态 ==================

    /**
     * 是否点赞/收藏
     */
    @Select("""
        SELECT COUNT(1)
        FROM video_action
        WHERE user_id = #{userId}
          AND video_id = #{videoId}
          AND action_type = #{actionType}
          AND state = 1
    """)
    int countActive(@Param("userId") Long userId,
                    @Param("videoId") Integer videoId,
                    @Param("actionType") Integer actionType);

    // ================== 批量查询 ==================

    /**
     * 查询用户对某个视频的所有行为
     */
    @Select("""
        SELECT * FROM video_action
        WHERE user_id = #{userId}
          AND video_id = #{videoId}
    """)
    List<UserVideoAction> selectByUserAndVideo(@Param("userId") Long userId,
                                               @Param("videoId") Integer videoId);

    /**
     * 查询用户所有点赞的视频
     */
    @Select("""
        SELECT video_id
        FROM video_action
        WHERE user_id = #{userId}
          AND action_type = 1
          AND state = 1
    """)
    List<Integer> selectLikedVideos(Long userId);

    /**
     * 查询用户所有收藏的视频
     */
    @Select("""
        SELECT video_id
        FROM video_action
        WHERE user_id = #{userId}
          AND action_type = 2
          AND state = 1
    """)
    List<Integer> selectFavoritedVideos(Long userId);

    // ================== 统计 ==================

    /**
     * 视频点赞数
     */
    @Select("""
        SELECT COUNT(1)
        FROM video_action
        WHERE video_id = #{videoId}
          AND action_type = 1
          AND state = 1
    """)
    int countLikes(Integer videoId);

    /**
     * 视频收藏数
     */
    @Select("""
        SELECT COUNT(1)
        FROM video_action
        WHERE video_id = #{videoId}
          AND action_type = 2
          AND state = 1
    """)
    int countFavorites(Integer videoId);

    // ================== 删除（物理删除，一般不用） ==================

    @Delete("""
        DELETE FROM video_action
        WHERE user_id = #{userId}
          AND video_id = #{videoId}
          AND action_type = #{actionType}
    """)
    int delete(@Param("userId") Long userId,
               @Param("videoId") Integer videoId,
               @Param("actionType") Integer actionType);
}