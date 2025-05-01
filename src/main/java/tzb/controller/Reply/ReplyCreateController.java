package tzb.controller.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Reply;
import tzb.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyCreateController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/add")
    public String addReply(@RequestBody Reply reply) {
        return replyService.addReply(reply) > 0 ? "success" : "fail";
    }
}
