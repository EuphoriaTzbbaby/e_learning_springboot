package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;

import java.util.List;

@RestController
@RequestMapping("/note-comments/query")
public class NoteCommentsQueryController {

    @Autowired
    private NoteCommentsService noteCommentsService;

    @GetMapping("/all")
    public ResponseEntity<List<NoteComments>> getAllComments() {
        List<NoteComments> comments = noteCommentsService.findAll();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteComments> getCommentById(@PathVariable Long id) {
        NoteComments comment = noteCommentsService.findById(id);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/commentId/{commentId}")
    public ResponseEntity<NoteComments> getCommentByCommentId(@PathVariable String commentId) {
        NoteComments comment = noteCommentsService.findByCommentId(commentId);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/noteId/{noteId}")
    public ResponseEntity<List<NoteComments>> getCommentsByNoteId(@PathVariable String noteId) {
        List<NoteComments> comments = noteCommentsService.findByNoteId(noteId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<NoteComments>> getCommentsByUserId(@PathVariable String userId) {
        List<NoteComments> comments = noteCommentsService.findByUserId(userId);
        return ResponseEntity.ok(comments);
    }
}