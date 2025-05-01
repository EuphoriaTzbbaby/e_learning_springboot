package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.Comment;
import tzb.pojo.Users;
import tzb.pojo.Video;
import tzb.service.CommentService;
import tzb.service.UsersService;
import tzb.service.VideoService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class CommentTests {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private VideoService videoService;
    private static final Random RANDOM = new Random();
    @Test
    public void addComment() {
        List<Users> users = usersService.selectAll();
        List<Video> videos = videoService.getAll();
        String[] comments = {
                "这部视频真是太棒了！",
                "节奏有点慢，但演员的表现很出色。",
                "没有我期待的那么好，看完有点失望。",
                "同感！非常喜欢这部片子！",
                "剧情确实很吸引人，不过结局有点出乎意料。",
                "同意，尤其是主角的演技让我印象深刻。"
        };
        for(Video video : videos){
            for(Users user : users){
                if(user.getRole().equals("admin")) continue;
                int x = RANDOM.nextInt(comments.length);
                String comment = comments[x];
                Comment v = new Comment();
                v.setVideoId(video.getId());
                v.setUserId(user.getId());
                v.setContent(comment);
                v.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
                commentService.addComment(v);
            }
        }
    }
}
