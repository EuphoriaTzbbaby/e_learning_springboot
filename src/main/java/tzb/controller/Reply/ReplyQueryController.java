package tzb.controller.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Reply;
import tzb.service.ReplyService;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyQueryController {

    @Autowired
    private ReplyService replyService;
    @GetMapping("/select/all")
    public List<Reply> selectAll() {
        return replyService.getAllReply();
    }
    @GetMapping("/byId/{id}")
    public Reply getReplyById(@PathVariable long id) {
        return replyService.getReplyById(id);
    }

    @GetMapping("/byCommentId/{commentId}")
    public List<Reply> getRepliesByCommentId(@PathVariable long commentId) {
        return replyService.getRepliesByCommentId(commentId);
    }
}
