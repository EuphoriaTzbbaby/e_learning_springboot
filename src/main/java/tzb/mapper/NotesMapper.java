package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Notes;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM notes")
    List<Notes> selectAll();

    @Select("SELECT * FROM notes WHERE id = #{id}")
    Notes selectById(Long id);

    @Select("SELECT * FROM notes WHERE note_id = #{noteId}")
    Notes selectByNoteId(String noteId);

    @Insert("INSERT INTO notes(note_id, title, url, created_at) " +
            "VALUES(#{noteId}, #{title}, #{url}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Notes notes);

    @Update("UPDATE notes SET title = #{title}, url = #{url} WHERE id = #{id}")
    int update(Notes notes);

    @Delete("DELETE FROM notes WHERE id = #{id}")
    int deleteById(Long id);

    @Delete("DELETE FROM notes WHERE note_id = #{noteId}")
    int deleteByNoteId(String noteId);
}