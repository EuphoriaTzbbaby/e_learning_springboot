package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Attendance {

  private long id;
  private long classId;
  private long studentId;
  private long courseId;
  private String status;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private java.sql.Date recordDate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createdAt;
}
