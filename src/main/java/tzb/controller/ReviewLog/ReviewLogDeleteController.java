package tzb.controller.ReviewLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tzb.service.ReviewLogService;
@RestController
@RequestMapping("/api/reviewLogs/delete")
public class ReviewLogDeleteController {
    @Autowired
    private ReviewLogService reviewLogService;
    @DeleteMapping("/{logId}")
    public String deleteReviewLog(@PathVariable Long logId) {
        int result = reviewLogService.deleteReviewLog(logId);
        return result > 0 ? "删除成功" : "删除失败";
    }
}