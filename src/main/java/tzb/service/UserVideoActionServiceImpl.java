package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.UserVideoActionMapper;
import tzb.pojo.UserVideoAction;
import tzb.service.UserVideoActionService;

import java.util.List;

@Service
public class UserVideoActionServiceImpl implements UserVideoActionService {

    @Autowired
    private UserVideoActionMapper mapper;

    /**
     * 核心：直接 upsert（无查询🔥）
     */
    @Override
    public void doAction(Long userId, Integer videoId, Integer actionType, Integer state) {

        UserVideoAction action = new UserVideoAction();
        action.setUserId(userId);
        action.setVideoId(videoId);
        action.setActionType(actionType);
        action.setState(state);

        mapper.saveOrUpdate(action);
    }

    @Override
    public boolean isAction(Long userId, Integer videoId, Integer actionType) {
        return mapper.countActive(userId, videoId, actionType) > 0;
    }

    @Override
    public List<Integer> getUserActions(Long userId, Integer videoId) {
        // 返回 actionType 列表（1=点赞，2=收藏）
        return mapper.selectByUserAndVideo(userId, videoId)
                .stream()
                .filter(a -> a.getState() == 1)
                .map(a -> a.getActionType())
                .toList();
    }

    @Override
    public int getLikeCount(Integer videoId) {
        return mapper.countLikes(videoId);
    }

    @Override
    public int getFavoriteCount(Integer videoId) {
        return mapper.countFavorites(videoId);
    }

    @Override
    public List<Integer> getLikedVideos(Long userId) {
        return mapper.selectLikedVideos(userId);
    }

    @Override
    public List<Integer> getFavoritedVideos(Long userId) {
        return mapper.selectFavoritedVideos(userId);
    }
}