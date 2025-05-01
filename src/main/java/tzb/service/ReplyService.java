package tzb.service;

import tzb.pojo.Reply;

import java.util.List;

public interface ReplyService {
    int addReply(Reply reply);
    List<Reply> getAllReply();
    Reply getReplyById(long id);
    List<Reply> getRepliesByCommentId(long commentId);
    int deleteReplyById(long id);
    int updateReplyContent(long id, String content);
}
