package tzb.controller.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyUpdateController {

    @Autowired
    private ReplyService replyService;

    @PutMapping("/update/{id}")
    public String updateReplyContent(@PathVariable long id, @RequestBody String content) {
        return replyService.updateReplyContent(id, content) > 0 ? "success" : "fail";
    }
}
