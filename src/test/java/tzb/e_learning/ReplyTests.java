package tzb.e_learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tzb.pojo.Comment;
import tzb.pojo.Reply;
import tzb.pojo.Users;
import tzb.pojo.Video;
import tzb.service.CommentService;
import tzb.service.ReplyService;
import tzb.service.UsersService;
import tzb.service.VideoService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class ReplyTests {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private VideoService videoService;
    private static final Random RANDOM = new Random();
    @Test
    public void addComment() {
        List<Users> users = usersService.selectAll();
        String[] reply = {
                "演员！",
                "我认为你说的对",
                "哈哈",
                "为什么",
                "啊啊啊",
                "可以可以"
        };
        for(Video vide : videoService.getAll()){
            if(vide.getId() % 3 != 0 && vide.getId() % 4 != 0) continue;
            for(Comment comment : commentService.getCommentsByVideoId(vide.getId())){
                for(int i = 0; i < users.size(); i++){
                    for(int j = 0; j < reply.length; j++){
                        if(i != j) {
                            int x =  RANDOM.nextInt(reply.length);
                            String replyContent = reply[x];
                            Reply rep = new Reply();
                            rep.setCommentId(comment.getId());
                            rep.setUserId(users.get(i).getId());
                            rep.setReplyToUserId(users.get(j).getId());
                            rep.setContent(replyContent);
                            rep.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
                            replyService.addReply(rep);
                        }
                    }
                }
            }
        }
    }
}
