package tzb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ReviewLogMapper;
import tzb.pojo.ReviewLog;
import tzb.service.ReviewLogService;
import java.util.List;
@Service
public class ReviewLogServiceImpl implements ReviewLogService {
    @Autowired
    private ReviewLogMapper reviewLogMapper;
    @Override
    public int addReviewLog(ReviewLog reviewLog) {
        return reviewLogMapper.insert(reviewLog);
    }
    @Override
    public int deleteReviewLog(Long logId) {
        return reviewLogMapper.deleteById(logId);
    }
    @Override
    public int updateReviewLog(ReviewLog reviewLog) {
        return reviewLogMapper.update(reviewLog);
    }
    @Override
    public ReviewLog getReviewLogById(Long logId) {
        return reviewLogMapper.selectById(logId);
    }
    @Override
    public List<ReviewLog> getAllReviewLogs() {
        return reviewLogMapper.selectAll();
    }
}