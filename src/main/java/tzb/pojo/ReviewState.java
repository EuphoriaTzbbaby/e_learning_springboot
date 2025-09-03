package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ReviewState {

  private long id;
  private long userId;
  private long egId;
  private long intervalDays;
  private double strength;
  private double difficulty;
  private double forgettingIdx;
  private long repetitions;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp lastReview;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp nextReview;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createDate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp updateDate;
}
