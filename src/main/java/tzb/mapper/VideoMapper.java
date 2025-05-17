package tzb.mapper;

import tzb.pojo.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {
    @Select("SELECT * FROM video WHERE id = #{id}")
    Video selectById(long id);

    @Select("SELECT * FROM video")
    List<Video> selectAll();
    @Select("select * from video where album_id = #{id}")
    List<Video> selectByAlbumId(long id);
    @Insert("INSERT INTO video(album_id, title, oss_key, video_url, duration, sort_order, create_time) VALUES(#{albumId}, #{title}, #{ossKey}, #{videoUrl}, #{duration}, #{sortOrder}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Video video);

    @Update("UPDATE video SET album_id=#{albumId}, title=#{title}, oss_key=#{ossKey}, video_url=#{videoUrl}, duration=#{duration}, sort_order=#{sortOrder}, create_time=#{createTime} WHERE id=#{id}")
    int update(Video video);

    @Delete("DELETE FROM video WHERE id=#{id}")
    int delete(long id);
}