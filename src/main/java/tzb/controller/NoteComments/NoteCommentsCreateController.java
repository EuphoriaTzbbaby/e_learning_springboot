package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;

@RestController
@RequestMapping("/note-comments/create")
public class NoteCommentsCreateController {

    @Autowired
    private NoteCommentsService noteCommentsService;

    @PostMapping
    public ResponseEntity<NoteComments> createComment(@RequestBody NoteComments comment) {
        boolean success = noteCommentsService.save(comment);
        if (success) {
            return new ResponseEntity<>(comment, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}