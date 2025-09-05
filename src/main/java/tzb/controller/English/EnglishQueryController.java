package tzb.controller.English;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.English;
import tzb.service.EnglishService;
import tzb.utils.Match;
import tzb.utils.StringSplitter;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/english")
public class EnglishQueryController {

    @Autowired
    private EnglishService englishService;

    @GetMapping("/get/{id}")
    public English getById(@PathVariable("id") long id) {
        return englishService.selectById(id);
    }
    @GetMapping("/get/selectVal/{selectVal}")
    public List<English> getBySelectVal(@PathVariable("selectVal") String selectVal) {
        List<English> list = englishService.selectAll();
        Match match = new Match();
        List<English> englishList = new ArrayList<>();
        for(English english : list) {
            Object[] nums = {
                    english.getTranslation(),
                    english.getComment(),
                    english.getContent(),
                    String.valueOf(english.getEgId()),
                    english.getStatus(),
                    english.getCoreKey(),
                    String.valueOf(english.getCreateDate()),
                    String.valueOf(english.getUpdateDate()),
                    String.valueOf(english.getIsDeleted())
            };
            for(Object s : nums) {
                for(String ss : StringSplitter.splitByCustomDelimiters((String) s)) {
                    if(match.checkContainSubsequence(ss, selectVal)) {
                        englishList.add(english);
                        break;
                    }
                }
            }
        }
        return englishList;
    }
    @GetMapping("/list")
    public List<English> getAll() {
        return englishService.selectAll();
    }
    // 批量获取 English
    @PostMapping("/getByIds")
    public List<English> getByIds(@RequestBody IdsRequest idsRequest) {
        List<English> list = englishService.getByIds(idsRequest.getIds());
        return list;
    }

    // DTO 用来接收前端 ids 数组
    public static class IdsRequest {
        private List<Long> ids;

        public List<Long> getIds() { return ids; }
        public void setIds(List<Long> ids) { this.ids = ids; }
    }
}
