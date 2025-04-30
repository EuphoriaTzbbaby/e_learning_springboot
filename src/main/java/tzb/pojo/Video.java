package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createTime;
}
