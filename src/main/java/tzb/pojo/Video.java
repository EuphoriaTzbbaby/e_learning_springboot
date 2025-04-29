package tzb.pojo;

import lombok.Data;

@Data
public class Video {

  private long id;
  private long albumId;
  private String title;
  private String ossKey;
  private String videoUrl;
  private long duration;
  private long sortOrder;
  private java.sql.Timestamp createTime;
}
