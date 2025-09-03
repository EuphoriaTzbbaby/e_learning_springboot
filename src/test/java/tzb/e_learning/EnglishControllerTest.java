package tzb.e_learning;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tzb.pojo.English;
import tzb.pojo.ReviewState;
import tzb.service.EnglishService;
import tzb.service.ReviewStateService;
import tzb.utils.ShiftDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static java.util.Collections.min;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class EnglishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EnglishService englishService;

    @Autowired
    private ReviewStateService reviewStateService;
    @Test
    public void fuck() {
        List<English> englishList = englishService.selectAll();
        for(English english : englishList) {
            if(english.getIsDeleted() == 1) {
                continue;
            }
            LocalDateTime nowShanghai = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));


            // 转成 UTC 时间，存入 TIMESTAMP
            Timestamp s = Timestamp.valueOf(nowShanghai);

//            System.out.println(s); // 输出原始 Timestamp


            ReviewState reviewState = new ReviewState();
            reviewState.setUserId(english.getUserId());
            reviewState.setEgId(english.getEgId());
            reviewState.setIntervalDays(0);
            reviewState.setStrength(0);
            long l = english.getContent().length();
            double v = (double) l / 10 * 0.1;
            v = Math.min(v, 1.0);
            reviewState.setDifficulty(v);
            reviewState.setForgettingIdx(0);
            reviewState.setRepetitions(0);
            reviewState.setLastReview(s);
            reviewState.setNextReview(s);
            reviewState.setCreateDate(s);
            reviewState.setUpdateDate(s);
            reviewStateService.addReviewState(reviewState);
//            break;
        }
    }

    @Test
    public void cnm() {
        List<English> englishList = englishService.selectAll();
// 确保map已初始化且不为null
        Map<Character, Integer> map = new HashMap<>();

        for(English english : englishList) {
            if(english != null && english.getIsDeleted() == 0 &&
                    (english.getCoreKey().equals("单词") || english.getCoreKey().equals("辨析"))) {

                String content = english.getContent();
                if(content != null && !content.isEmpty()) {
                    char firstChar = content.charAt(0);
//                    if('磨' == content.charAt(0)) {
//                        System.out.println(content);
//                    }
                    // 使用getOrDefault避免NullPointerException
                    map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
                }
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // 按值升序排序
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println(map);
    }
    @Test
    public void testAddEnglish() throws Exception {
        English english = new English();
        english.setUserId(1);
        english.setContent("This is a test content.");
        english.setCoreKey("test");
        english.setComment("This is a test.");
        english.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        english.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        english.setIsDeleted(0);
        english.setStatus("draft");

        mockMvc.perform(post("/english/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(english)))
                .andExpect(status().isOk())
                .andExpect(content().string("Insert successful"));
    }

    @Test
    public void testGetEnglishById() throws Exception {
        long testId = 1L; // 确保数据库中存在该ID的记录
        mockMvc.perform(get("/english/get/{id}", testId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.egId").value(testId));
    }

    @Test
    public void testUpdateEnglish() throws Exception {
        English updated = new English();
        updated.setEgId(1L); // 目标更新ID
        updated.setUserId(1L);
        updated.setContent("Updated content");
        updated.setCoreKey("updated");
        updated.setComment("Updated comment");
        updated.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        updated.setIsDeleted(0L);
        updated.setStatus("published");

        mockMvc.perform(put("/english/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(content().string("Update successful"));
    }

    @Test
    public void testDeleteEnglish() throws Exception {
        long testId = 1L; // 请确保此ID存在，或先调用 testAddEnglish 插入
        mockMvc.perform(delete("/english/delete/{id}", testId))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete successful"));
    }
}
