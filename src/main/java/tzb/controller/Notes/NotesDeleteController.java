package tzb.controller.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.service.NotesService;

@RestController
@RequestMapping("/notes/delete")
public class NotesDeleteController {

    @Autowired
    private NotesService notesService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = notesService.removeById(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/noteId/{noteId}")
    public ResponseEntity<Void> deleteNoteByNoteId(@PathVariable String noteId) {
        boolean deleted = notesService.removeByNoteId(noteId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}