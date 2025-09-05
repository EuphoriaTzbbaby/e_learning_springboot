package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ReviewLog {

  private long logId;
  private long userId;
  private long egId;
  private long score;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp lastReview;
}
