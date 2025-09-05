package tzb.controller.ReviewLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.pojo.ReviewLog;
import tzb.service.ReviewLogService;
@RestController
@RequestMapping("/api/reviewLogs")
public class ReviewLogCreateController {
    @Autowired
    private ReviewLogService reviewLogService;
    @PostMapping
    public String addReviewLog(@RequestBody ReviewLog reviewLog) {
        int result = reviewLogService.addReviewLog(reviewLog);
        return result > 0 ? "添加成功" : "添加失败";
    }
}