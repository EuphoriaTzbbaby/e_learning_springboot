package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;

import java.util.List;

@RestController
@RequestMapping("/note-comments")
public class NoteCommentsCreateController {

    @Autowired
    private NoteCommentsService noteCommentsService;

    // 单条插入接口，保持原有
    @PostMapping("/create")
    public ResponseEntity<NoteComments> createComment(@RequestBody NoteComments comment) {
        boolean success = noteCommentsService.save(comment);
        if (success) {
            return new ResponseEntity<>(comment, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 新增批量插入接口
    @PostMapping("/batch-create")
    public ResponseEntity<String> batchCreateComments(@RequestBody List<NoteComments> comments) {
        boolean success = noteCommentsService.saveBatch(comments);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("成功插入 " + comments.size() + " 条评论");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("批量插入失败");
        }
    }
}
