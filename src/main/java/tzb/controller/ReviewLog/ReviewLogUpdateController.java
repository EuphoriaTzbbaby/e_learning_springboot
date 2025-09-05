package tzb.controller.ReviewLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.ReviewLog;
import tzb.service.ReviewLogService;
@RestController
@RequestMapping("/api/reviewLogs")
public class ReviewLogUpdateController {
    @Autowired
    private ReviewLogService reviewLogService;
    @PutMapping
    public String updateReviewLog(@RequestBody ReviewLog reviewLog) {
        int result = reviewLogService.updateReviewLog(reviewLog);
        return result > 0 ? "更新成功" : "更新失败";
    }
}