package tzb.controller.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Comment;
import tzb.service.CommentService;

import java.sql.Timestamp;

@RestController
@RequestMapping("/comment")
public class CommentCreateController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public String addComment(@RequestBody Comment comment) {
        comment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return commentService.addComment(comment) > 0 ? "添加成功" : "添加失败";
    }
}
