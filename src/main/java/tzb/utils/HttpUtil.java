// HttpUtil.java
package tzb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String postJson(String url, String jsonBody, String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public static String postDeepSeek(String apiKey, Map<String, Object> requestBody) {
        try {
            String jsonBody = objectMapper.writeValueAsString(requestBody);
            return postJson("https://api.deepseek.com/chat/completions", jsonBody, apiKey);
        } catch (Exception e) {
            throw new RuntimeException("DeepSeek请求失败", e);
        }
    }
}
