package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Reply;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Insert("INSERT INTO reply (comment_id, user_id, reply_to_user_id, content, create_time) " +
            "VALUES (#{commentId}, #{userId}, #{replyToUserId}, #{content}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertReply(Reply reply);

    @Select("select * from reply")
    List<Reply> getAllReply();
    @Select("SELECT * FROM reply WHERE id = #{id}")
    Reply getReplyById(@Param("id") long id);

    @Select("SELECT * FROM reply WHERE comment_id = #{commentId} ORDER BY create_time ASC")
    List<Reply> getRepliesByCommentId(@Param("commentId") long commentId);

    @Delete("DELETE FROM reply WHERE id = #{id}")
    int deleteReplyById(@Param("id") long id);

    @Update("UPDATE reply SET content = #{content} WHERE id = #{id}")
    int updateReplyContent(@Param("id") long id, @Param("content") String content);
}
