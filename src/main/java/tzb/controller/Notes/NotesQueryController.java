package tzb.controller.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Notes;
import tzb.service.NotesService;

import java.util.List;

@RestController
@RequestMapping("/notes/query")
public class NotesQueryController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/all")
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> notes = notesService.findAll();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable Long id) {
        Notes note = notesService.findById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/noteId/{noteId}")
    public ResponseEntity<Notes> getNoteByNoteId(@PathVariable String noteId) {
        Notes note = notesService.findByNoteId(noteId);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}