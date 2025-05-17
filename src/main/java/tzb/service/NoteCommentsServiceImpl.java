package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.NoteCommentsMapper;
import tzb.pojo.NoteComments;
import tzb.service.NoteCommentsService;

import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class NoteCommentsServiceImpl implements NoteCommentsService {

    @Autowired
    private NoteCommentsMapper noteCommentsMapper;

    @Override
    public List<NoteComments> findAll() {
        return noteCommentsMapper.selectAll();
    }

    @Override
    public NoteComments findById(Long id) {
        return noteCommentsMapper.selectById(id);
    }

    @Override
    public NoteComments findByCommentId(String commentId) {
        return noteCommentsMapper.selectByCommentId(commentId);
    }

    @Override
    public List<NoteComments> findByNoteId(String noteId) {
        return noteCommentsMapper.selectByNoteId(noteId);
    }

    @Override
    public List<NoteComments> findByUserId(String userId) {
        return noteCommentsMapper.selectByUserId(userId);
    }

    @Override
    public boolean save(NoteComments noteComments) {
        // 设置commentId和创建时间
        if (noteComments.getCommentId() == null || noteComments.getCommentId().isEmpty()) {
            noteComments.setCommentId(UUID.randomUUID().toString());
        }
        if (noteComments.getCreatedAt() == null) {
            noteComments.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        }
        if (noteComments.getLikeCount() <= 0) {
            noteComments.setLikeCount(0);
        }
        return noteCommentsMapper.insert(noteComments) > 0;
    }

    @Override
    public boolean update(NoteComments noteComments) {
        return noteCommentsMapper.update(noteComments) > 0;
    }

    @Override
    public boolean removeById(Long id) {
        return noteCommentsMapper.deleteById(id) > 0;
    }

    @Override
    public boolean removeByCommentId(String commentId) {
        return noteCommentsMapper.deleteByCommentId(commentId) > 0;
    }

    @Override
    public boolean removeByNoteId(String noteId) {
        return noteCommentsMapper.deleteByNoteId(noteId) > 0;
    }
}