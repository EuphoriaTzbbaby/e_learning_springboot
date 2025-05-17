package tzb.service;

import tzb.pojo.Notes;
import java.util.List;

public interface NotesService {

    List<Notes> findAll();

    Notes findById(Long id);

    Notes findByNoteId(String noteId);

    boolean save(Notes notes);

    boolean update(Notes notes);

    boolean removeById(Long id);

    boolean removeByNoteId(String noteId);
}