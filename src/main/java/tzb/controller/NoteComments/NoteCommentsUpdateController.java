package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;

@RestController
@RequestMapping("/note-comments/update")
public class NoteCommentsUpdateController {

    @Autowired
    private NoteCommentsService noteCommentsService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody NoteComments comment) {
        comment.setId(id);
        boolean updated = noteCommentsService.update(comment);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}