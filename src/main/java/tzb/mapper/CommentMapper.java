package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("INSERT INTO comment(video_id, user_id, content, create_time) " +
            "VALUES(#{videoId}, #{userId}, #{content}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertComment(Comment comment);

    @Select("select * from comment")
    List<Comment> getAllComment();
    @Select("SELECT * FROM comment WHERE id = #{id}")
    Comment findById(long id);

    @Select("SELECT * FROM comment WHERE video_id = #{videoId} ORDER BY create_time DESC")
    List<Comment> findByVideoId(long videoId);

    @Delete("DELETE FROM comment WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE comment SET content = #{content} WHERE id = #{id}")
    int updateContent(Comment comment);
}
