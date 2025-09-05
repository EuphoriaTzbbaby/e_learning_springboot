package tzb.service;
import tzb.pojo.ReviewLog;
import java.util.List;
public interface ReviewLogService {
    int addReviewLog(ReviewLog reviewLog);
    int deleteReviewLog(Long logId);
    int updateReviewLog(ReviewLog reviewLog);
    ReviewLog getReviewLogById(Long logId);
    List<ReviewLog> getAllReviewLogs();
}