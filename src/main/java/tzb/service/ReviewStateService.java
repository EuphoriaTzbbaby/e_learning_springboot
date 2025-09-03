package tzb.service;

import tzb.pojo.ReviewState;
import java.util.List;

public interface ReviewStateService {
    int addReviewState(ReviewState reviewState);
    ReviewState getReviewStateById(long id);
    List<ReviewState> getReviewStatesByUserId(long userId);
    List<ReviewState> getDueReviews(long userId);
    int updateReviewState(ReviewState reviewState);
    int deleteReviewState(long id);
    List<ReviewState> getAllReviewStates();
}
