package tzb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class NoteComments {

  private long id;
  private String noteId;
  private String commentId;
  private String userId;
  private String nickname;
  private String gender;
  private String ipLocation;
  private String content;
  private long likeCount;
  private String level;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp createdAt;

}
