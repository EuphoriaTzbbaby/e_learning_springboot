package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.NotesMapper;
import tzb.pojo.Notes;
import tzb.service.NotesService;

import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesMapper notesMapper;

    @Override
    public List<Notes> findAll() {
        return notesMapper.selectAll();
    }

    @Override
    public Notes findById(Long id) {
        return notesMapper.selectById(id);
    }

    @Override
    public Notes findByNoteId(String noteId) {
        return notesMapper.selectByNoteId(noteId);
    }

    @Override
    public boolean save(Notes notes) {
        // 设置noteId和创建时间
        if (notes.getNoteId() == null || notes.getNoteId().isEmpty()) {
            notes.setNoteId(UUID.randomUUID().toString());
        }
        if (notes.getCreatedAt() == null) {
            notes.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        }
        return notesMapper.insert(notes) > 0;
    }

    @Override
    public boolean update(Notes notes) {
        return notesMapper.update(notes) > 0;
    }

    @Override
    public boolean removeById(Long id) {
        return notesMapper.deleteById(id) > 0;
    }

    @Override
    public boolean removeByNoteId(String noteId) {
        return notesMapper.deleteByNoteId(noteId) > 0;
    }
}