package tzb.controller.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.pojo.Notes;
import tzb.service.NotesService;
import tzb.utils.Match;

import java.util.ArrayList;
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
    @GetMapping("/selectVal/{selectVal}")
    public ResponseEntity<List<Notes>> getNotesBySelectVal(@PathVariable("selectVal") String selectVal) {
        List<Notes> res = notesService.findAll();
        List<Notes> ans = new ArrayList<>();
        Match match = new Match();
        for(Notes notes : res) {
            if(match.checkContainSubsequence(selectVal, notes.getTitle())) {
                ans.add(notes);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, notes.getNoteId())) {
                ans.add(notes);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, notes.getUrl())) {
                ans.add(notes);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(notes.getId()))) {
                ans.add(notes);
                continue;
            }
            if(match.checkContainSubsequence(selectVal, String.valueOf(notes.getCreatedAt()))) {
                ans.add(notes);
            }
        }
        return ResponseEntity.ok(ans);
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