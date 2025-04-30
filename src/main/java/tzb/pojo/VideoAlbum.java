package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class VideoAlbum {

  private long id;
  private String title;
  private String description;
  private String coverUrl;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createTime;
}