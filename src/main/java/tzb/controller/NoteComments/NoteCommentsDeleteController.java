package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.service.NoteCommentsService;

@RestController
@RequestMapping("/note-comments/delete")
public class NoteCommentsDeleteController {

    @Autowired
    private NoteCommentsService noteCommentsService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        boolean deleted = noteCommentsService.removeById(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/commentId/{commentId}")
    public ResponseEntity<Void> deleteCommentByCommentId(@PathVariable String commentId) {
        boolean deleted = noteCommentsService.removeByCommentId(commentId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/noteId/{noteId}")
    public ResponseEntity<Void> deleteCommentsByNoteId(@PathVariable String noteId) {
        boolean deleted = noteCommentsService.removeByNoteId(noteId);
        return ResponseEntity.ok().build();
    }
}