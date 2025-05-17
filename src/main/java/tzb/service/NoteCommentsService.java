package tzb.service;

import tzb.pojo.NoteComments;
import java.util.List;

public interface NoteCommentsService {

    List<NoteComments> findAll();

    NoteComments findById(Long id);

    NoteComments findByCommentId(String commentId);

    List<NoteComments> findByNoteId(String noteId);

    List<NoteComments> findByUserId(String userId);

    boolean save(NoteComments noteComments);

    boolean update(NoteComments noteComments);

    boolean removeById(Long id);

    boolean removeByCommentId(String commentId);

    boolean removeByNoteId(String noteId);
}