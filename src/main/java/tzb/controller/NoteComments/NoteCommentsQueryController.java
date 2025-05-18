package tzb.controller.NoteComments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;
import tzb.utils.Match;

import java.util.ArrayList;
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

    @GetMapping("/selectVal/{selectVal}")
    public ResponseEntity<List<NoteComments>> getCommentsBySelectVal(@PathVariable("selectVal") String selectVal) {
        List<NoteComments> res = noteCommentsService.findAll();
        List<NoteComments> comments = new ArrayList<>();
        Match match = new Match();
        for(NoteComments noteComments : res) {
            if(match.checkContainSubsequence(noteComments.getCommentId(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getGender(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getNoteId(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getContent(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getLevel(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getNickname(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getIpLocation(), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(String.valueOf(noteComments.getCreatedAt()), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(String.valueOf(noteComments.getLikeCount()), selectVal)) {
                comments.add(noteComments);
                continue;
            }
            if(match.checkContainSubsequence(noteComments.getUserId(), selectVal)) {
                comments.add(noteComments);
            }
        }
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