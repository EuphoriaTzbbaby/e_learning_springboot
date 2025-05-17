package tzb.controller.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentDeleteController {

    @Autowired
    private CommentService commentService;

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable long id) {
        return commentService.deleteComment(id) ? "删除成功" : "删除失败";
    }
}
