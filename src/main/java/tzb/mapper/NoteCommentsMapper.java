package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.NoteComments;

import java.util.List;

@Mapper
public interface NoteCommentsMapper {

    @Select("SELECT * FROM note_comments")
    List<NoteComments> selectAll();

    @Select("SELECT * FROM note_comments WHERE id = #{id}")
    NoteComments selectById(Long id);

    @Select("SELECT * FROM note_comments WHERE note_id = #{noteId}")
    List<NoteComments> selectByNoteId(String noteId);

    @Select("SELECT * FROM note_comments WHERE comment_id = #{commentId}")
    NoteComments selectByCommentId(String commentId);

    @Select("SELECT * FROM note_comments WHERE user_id = #{userId}")
    List<NoteComments> selectByUserId(String userId);

    @Insert("INSERT INTO note_comments(note_id, comment_id, user_id, nickname, gender, ip_location, content, like_count, level, created_at) " +
            "VALUES(#{noteId}, #{commentId}, #{userId}, #{nickname}, #{gender}, #{ipLocation}, #{content}, #{likeCount}, #{level}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(NoteComments noteComments);

    @Update("UPDATE note_comments SET content = #{content}, like_count = #{likeCount}, level = #{level} WHERE id = #{id}")
    int update(NoteComments noteComments);

    @Delete("DELETE FROM note_comments WHERE id = #{id}")
    int deleteById(Long id);

    @Delete("DELETE FROM note_comments WHERE comment_id = #{commentId}")
    int deleteByCommentId(String commentId);

    @Delete("DELETE FROM note_comments WHERE note_id = #{noteId}")
    int deleteByNoteId(String noteId);
}