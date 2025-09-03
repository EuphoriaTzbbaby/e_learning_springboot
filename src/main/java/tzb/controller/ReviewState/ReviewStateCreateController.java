package tzb.controller.ReviewState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.ReviewState;
import tzb.service.ReviewStateService;

@RestController
@RequestMapping("/reviewState")
public class ReviewStateCreateController {

    @Autowired
    private ReviewStateService reviewStateService;

    @PostMapping
    public String addReviewState(@RequestBody ReviewState reviewState) {
        int rows = reviewStateService.addReviewState(reviewState);
        return rows > 0 ? "Insert success" : "Insert failed";
    }
}
