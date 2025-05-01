package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.CommentMapper;
import tzb.pojo.Comment;
import tzb.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }
    @Override
    public int addComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentMapper.findById(id);
    }

    @Override
    public List<Comment> getCommentsByVideoId(long videoId) {
        return commentMapper.findByVideoId(videoId);
    }

    @Override
    public boolean deleteComment(long id) {
        return commentMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentMapper.updateContent(comment) > 0;
    }
}
