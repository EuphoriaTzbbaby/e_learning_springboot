package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class English {

  private long egId;
  private long userId;
  private String content;
  private String coreKey;
  private String translation;
  private String comment;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createDate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp updateDate;
  private long isDeleted;
  private String status;
  private long isTaboo;
  private long textCnt;
}
