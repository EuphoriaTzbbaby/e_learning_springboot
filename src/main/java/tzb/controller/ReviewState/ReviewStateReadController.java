package tzb.controller.ReviewState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.ReviewState;
import tzb.service.ReviewStateService;

import java.util.List;

@RestController
@RequestMapping("/reviewState/read")
public class ReviewStateReadController {

    @Autowired
    private ReviewStateService reviewStateService;

    @GetMapping("/{id}")
    public ReviewState getReviewStateById(@PathVariable long id) {
        return reviewStateService.getReviewStateById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ReviewState> getReviewStatesByUserId(@PathVariable long userId) {

        return reviewStateService.getReviewStatesByUserId(userId);
    }

    @GetMapping("/due/{userId}")
    public List<ReviewState> getDueReviews(@PathVariable long userId) {
        return reviewStateService.getDueReviews(userId);
    }

    @GetMapping("/all")
    public List<ReviewState> getAllReviewStates() {
        return reviewStateService.getAllReviewStates();
    }
}
