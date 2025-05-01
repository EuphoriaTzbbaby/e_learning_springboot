package tzb.controller.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyDeleteController {

    @Autowired
    private ReplyService replyService;

    @DeleteMapping("/delete/{id}")
    public String deleteReply(@PathVariable long id) {
        return replyService.deleteReplyById(id) > 0 ? "success" : "fail";
    }
}
