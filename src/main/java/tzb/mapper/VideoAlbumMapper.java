// Mapper 接口
package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.VideoAlbum;
import java.util.List;

@Mapper
public interface VideoAlbumMapper {

    @Select("SELECT * FROM video_album")
    List<VideoAlbum> selectAll();

    @Select("SELECT * FROM video_album WHERE id = #{id}")
    VideoAlbum selectById(long id);

    @Insert("INSERT INTO video_album(title, description, cover_url, create_time) VALUES(#{title}, #{description}, #{coverUrl}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(VideoAlbum videoAlbum);

    @Delete("DELETE FROM video_album WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE video_album SET title=#{title}, description=#{description}, cover_url=#{coverUrl} WHERE id=#{id}")
    int update(VideoAlbum videoAlbum);
}