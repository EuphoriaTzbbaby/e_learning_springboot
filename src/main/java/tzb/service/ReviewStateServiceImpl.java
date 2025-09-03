package tzb.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tzb.mapper.ReviewStateMapper;
import tzb.pojo.ReviewState;
import tzb.service.ReviewStateService;

import java.util.List;

@Service
public class ReviewStateServiceImpl implements ReviewStateService {

    @Autowired
    private ReviewStateMapper reviewStateMapper;

    @Override
    public int addReviewState(ReviewState reviewState) {
        return reviewStateMapper.insert(reviewState);
    }

    @Override
    public ReviewState getReviewStateById(long id) {
        return reviewStateMapper.findById(id);
    }

    @Override
    public List<ReviewState> getReviewStatesByUserId(long userId) {
        return reviewStateMapper.findByUserId(userId);
    }

    @Override
    public List<ReviewState> getDueReviews(long userId) {
        return reviewStateMapper.findDueReviews(userId);
    }

    @Override
    public int updateReviewState(ReviewState reviewState) {
        return reviewStateMapper.update(reviewState);
    }

    @Override
    public int deleteReviewState(long id) {
        return reviewStateMapper.deleteById(id);
    }

    @Override
    public List<ReviewState> getAllReviewStates() {
        return reviewStateMapper.findAll();
    }
}
