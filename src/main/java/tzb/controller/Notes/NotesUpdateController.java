package tzb.controller.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Notes;
import tzb.service.NotesService;

@RestController
@RequestMapping("/notes/update")
public class NotesUpdateController {

    @Autowired
    private NotesService notesService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody Notes note) {
        note.setId(id);
        boolean updated = notesService.update(note);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}