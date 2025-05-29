package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CourseNotice {

  private long id;
  private long courseId;
  private long teacherId;
  private String title;
  private String content;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createTime;
}
