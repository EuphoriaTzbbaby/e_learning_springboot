package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class UserActionLog {

    private Long id;

    private Long userId;

    private String actionType;

    private String actionContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp actionTime;
}