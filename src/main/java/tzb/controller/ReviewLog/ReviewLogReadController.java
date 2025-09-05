package tzb.controller.ReviewLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.ReviewLog;
import tzb.service.ReviewLogService;
import java.util.List;
@RestController
@RequestMapping("/api/reviewLogs/get")
public class ReviewLogReadController {
    @Autowired
    private ReviewLogService reviewLogService;
    @GetMapping("/{userId}")
    public ReviewLog getReviewLogByUserId(@PathVariable Long userId) {
        return reviewLogService.getReviewLogById(userId);
    }
    @GetMapping
    public List<ReviewLog> getAllReviewLogs() {
        return reviewLogService.getAllReviewLogs();
    }
}