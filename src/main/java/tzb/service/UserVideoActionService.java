package tzb.service;

import java.util.List;

public interface UserVideoActionService {

    /**
     * 点赞/收藏 或 取消（统一入口）
     */
    void doAction(Long userId, Integer videoId, Integer actionType, Integer state);

    /**
     * 是否点赞/收藏
     */
    boolean isAction(Long userId, Integer videoId, Integer actionType);

    /**
     * 获取用户对视频的所有行为（点赞+收藏状态）
     */
    List<Integer> getUserActions(Long userId, Integer videoId);

    /**
     * 获取视频点赞数
     */
    int getLikeCount(Integer videoId);

    /**
     * 获取视频收藏数
     */
    int getFavoriteCount(Integer videoId);

    /**
     * 获取用户点赞的视频列表
     */
    List<Integer> getLikedVideos(Long userId);

    /**
     * 获取用户收藏的视频列表
     */
    List<Integer> getFavoritedVideos(Long userId);
}