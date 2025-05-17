package tzb.controller.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Comment;
import tzb.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentUpdateController {

    @Autowired
    private CommentService commentService;

    @PutMapping("/update")
    public String updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment) ? "更新成功" : "更新失败";
    }
}
