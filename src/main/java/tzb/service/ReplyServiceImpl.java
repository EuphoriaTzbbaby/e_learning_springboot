package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ReplyMapper;
import tzb.pojo.Reply;
import tzb.service.ReplyService;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int addReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public List<Reply> getAllReply() {
        return replyMapper.getAllReply();
    }
    @Override
    public Reply getReplyById(long id) {
        return replyMapper.getReplyById(id);
    }

    @Override
    public List<Reply> getRepliesByCommentId(long commentId) {
        return replyMapper.getRepliesByCommentId(commentId);
    }

    @Override
    public int deleteReplyById(long id) {
        return replyMapper.deleteReplyById(id);
    }

    @Override
    public int updateReplyContent(long id, String content) {
        return replyMapper.updateReplyContent(id, content);
    }
}
