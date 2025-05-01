package tzb.service;

import tzb.pojo.Comment;

import java.util.List;

public interface CommentService {

    int addComment(Comment comment);
    List<Comment> getAllComment();
    Comment getCommentById(long id);

    List<Comment> getCommentsByVideoId(long videoId);

    boolean deleteComment(long id);

    boolean updateComment(Comment comment);
}
