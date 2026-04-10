package tzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserVideoAction {

    private Long id;

    private Long userId;

    private Integer videoId;

    /**
     * 行为类型：
     * 1-点赞 2-收藏
     */
    private Integer actionType;

    /**
     * 状态：
     * 1-有效（点赞/收藏）
     * 0-取消
     */
    private Integer state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp updateTime;
}