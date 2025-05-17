package tzb.controller.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Notes;
import tzb.service.NotesService;

@RestController
@RequestMapping("/notes/create")
public class NotesCreateController {

    @Autowired
    private NotesService notesService;

    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes note) {
        boolean success = notesService.save(note);
        if (success) {
            return new ResponseEntity<>(note, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}