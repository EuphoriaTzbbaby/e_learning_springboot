package tzb.controller.ReviewState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.ReviewState;
import tzb.service.ReviewStateService;

@RestController
@RequestMapping("/reviewState")
public class ReviewStateUpdateController {

    @Autowired
    private ReviewStateService reviewStateService;

    @PutMapping
    public String updateReviewState(@RequestBody ReviewState reviewState) {
        int rows = reviewStateService.updateReviewState(reviewState);
        return rows > 0 ? "Update success" : "Update failed";
    }
}
