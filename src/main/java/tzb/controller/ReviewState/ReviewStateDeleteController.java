package tzb.controller.ReviewState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.ReviewStateService;

@RestController
@RequestMapping("/reviewState")
public class ReviewStateDeleteController {

    @Autowired
    private ReviewStateService reviewStateService;

    @DeleteMapping("/{id}")
    public String deleteReviewState(@PathVariable long id) {
        int rows = reviewStateService.deleteReviewState(id);
        return rows > 0 ? "Delete success" : "Delete failed";
    }
}
