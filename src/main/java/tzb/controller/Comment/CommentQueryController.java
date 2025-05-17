package tzb.controller.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Comment;
import tzb.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentQueryController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/select/all")
    public List<Comment> selectAllComment(){
        return commentService.getAllComment();
    }
    @GetMapping("/{id}")
    public Comment getComment(@PathVariable long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/video/{videoId}")
    public List<Comment> getCommentsByVideo(@PathVariable long videoId) {
        return commentService.getCommentsByVideoId(videoId);
    }
}
