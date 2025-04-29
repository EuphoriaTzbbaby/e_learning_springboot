package tzb.pojo;

import lombok.Data;

@Data
public class VideoAlbum {

  private long id;
  private String title;
  private String description;
  private String coverUrl;
  private java.sql.Timestamp createTime;
}