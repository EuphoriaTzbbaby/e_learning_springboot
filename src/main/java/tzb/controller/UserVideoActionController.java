package tzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.mapper.UserVideoActionMapper;
import tzb.pojo.UserVideoAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/video/action")
public class UserVideoActionController {

    @Autowired
    private UserVideoActionMapper mapper;

    // ================== 新增 / 更新（点赞/收藏/取消） ==================

    /**
     * 推荐：统一入口（upsert）
     */
    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody UserVideoAction action) {
        int rows = mapper.saveOrUpdate(action);

        Map<String, Object> res = new HashMap<>();
        res.put("success", rows > 0);
        res.put("rows", rows);
        return res;
    }

    // ================== 修改状态（取消/恢复） ==================

    @PutMapping("/state")
    public Map<String, Object> updateState(@RequestBody UserVideoAction action) {
        int rows = mapper.updateState(
                action.getUserId(),
                action.getVideoId(),
                action.getActionType(),
                action.getState()
        );

        Map<String, Object> res = new HashMap<>();
        res.put("success", rows > 0);
        res.put("rows", rows);
        return res;
    }

    // ================== 查询单条记录 ==================

    @GetMapping("/one")
    public UserVideoAction getOne(@RequestParam Long userId,
                                  @RequestParam Integer videoId,
                                  @RequestParam Integer actionType) {
        return mapper.selectOne(userId, videoId, actionType);
    }

    // ================== 是否已点赞/收藏 ==================

    @GetMapping("/active")
    public Map<String, Object> isActive(@RequestParam Long userId,
                                        @RequestParam Integer videoId,
                                        @RequestParam Integer actionType) {

        int count = mapper.countActive(userId, videoId, actionType);

        Map<String, Object> res = new HashMap<>();
        res.put("active", count > 0);
        return res;
    }

    // ================== 用户行为列表 ==================

    @GetMapping("/user/video")
    public List<UserVideoAction> listByUserAndVideo(@RequestParam Long userId,
                                                    @RequestParam Integer videoId) {
        return mapper.selectByUserAndVideo(userId, videoId);
    }

    @GetMapping("/user/{userId}/liked")
    public List<Integer> likedVideos(@PathVariable Long userId) {
        return mapper.selectLikedVideos(userId);
    }

    @GetMapping("/user/{userId}/favorited")
    public List<Integer> favoritedVideos(@PathVariable Long userId) {
        return mapper.selectFavoritedVideos(userId);
    }

    // ================== 视频统计 ==================

    @GetMapping("/video/{videoId}/likes")
    public Map<String, Object> likeCount(@PathVariable Integer videoId) {
        Map<String, Object> res = new HashMap<>();
        res.put("videoId", videoId);
        res.put("likes", mapper.countLikes(videoId));
        return res;
    }

    @GetMapping("/video/{videoId}/favorites")
    public Map<String, Object> favoriteCount(@PathVariable Integer videoId) {
        Map<String, Object> res = new HashMap<>();
        res.put("videoId", videoId);
        res.put("favorites", mapper.countFavorites(videoId));
        return res;
    }

    // ================== 删除（一般不建议用） ==================

    @DeleteMapping
    public Map<String, Object> delete(@RequestParam Long userId,
                                      @RequestParam Integer videoId,
                                      @RequestParam Integer actionType) {

        int rows = mapper.delete(userId, videoId, actionType);

        Map<String, Object> res = new HashMap<>();
        res.put("success", rows > 0);
        res.put("rows", rows);
        return res;
    }
}