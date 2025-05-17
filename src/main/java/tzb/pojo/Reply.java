package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Reply {

  private long id;
  private long commentId;
  private long userId;
  private long replyToUserId;
  private String content;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createTime;
}
