package tzb.mapper;

import org.apache.ibatis.annotations.Param;
import tzb.pojo.NoteComments;

import java.util.List;

public class NoteCommentsSqlProvider {
    public static String insertBatch(@Param("comments") List<NoteComments> comments) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO note_comments(note_id, comment_id, user_id, nickname, gender, ip_location, content, like_count, level, created_at) VALUES ");
        for (int i = 0; i < comments.size(); i++) {
            sql.append("(")
                    .append("#{comments[").append(i).append("].noteId}, ")
                    .append("#{comments[").append(i).append("].commentId}, ")
                    .append("#{comments[").append(i).append("].userId}, ")
                    .append("#{comments[").append(i).append("].nickname}, ")
                    .append("#{comments[").append(i).append("].gender}, ")
                    .append("#{comments[").append(i).append("].ipLocation}, ")
                    .append("#{comments[").append(i).append("].content}, ")
                    .append("#{comments[").append(i).append("].likeCount}, ")
                    .append("#{comments[").append(i).append("].level}, ")
                    .append("#{comments[").append(i).append("].createdAt}")
                    .append(")");
            if (i < comments.size() - 1) {
                sql.append(", ");
            }
        }
        return sql.toString();
    }
}
