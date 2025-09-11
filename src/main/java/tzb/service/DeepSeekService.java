// DeepSeekService.java
package tzb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.DeepSeekMapper;
import tzb.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeepSeekService {

    @Autowired
    private DeepSeekMapper deepSeekMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getApiKey() {
        try {
            // 先尝试按ID获取
            String apiKey = deepSeekMapper.getApiKeyById();
            if (apiKey != null && !apiKey.trim().isEmpty()) {
                return apiKey.trim();
            }

            // 如果ID获取失败，尝试按key获取
            apiKey = deepSeekMapper.getApiKeyByKey();
            if (apiKey != null && !apiKey.trim().isEmpty()) {
                return apiKey.trim();
            }

            throw new RuntimeException("未找到DeepSeek API密钥配置");
        } catch (Exception e) {
            throw new RuntimeException("获取API密钥失败: " + e.getMessage(), e);
        }
    }

    public String chat(String message, String systemPrompt) {
        try {
            String apiKey = getApiKey();

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "deepseek-chat");
            requestBody.put("max_tokens", 1000);
            requestBody.put("temperature", 0.7);

            Map<String, Object>[] messages = new Map[2];
            System.out.println(requestBody);
            // 系统提示
            Map<String, Object> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", systemPrompt != null ? systemPrompt : "You are a helpful assistant.");
            messages[0] = systemMessage;
            System.out.println(messages[0]);
            // 用户消息
            Map<String, Object> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", message);
            messages[1] = userMessage;
            System.out.println(messages[1]);
            requestBody.put("messages", messages);

            String response = HttpUtil.postDeepSeek(apiKey, requestBody);
            System.out.println(response);
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode choices = rootNode.path("choices");
            System.out.println(222);
            System.out.println(choices);
            if (!choices.isEmpty()) {
                JsonNode messageNode = choices.get(0).path("message");
                return messageNode.path("content").asText();
            }
            System.out.println(33333);
            throw new RuntimeException("未收到有效回复");

        } catch (Exception e) {
            throw new RuntimeException("AI聊天失败: " + e.getMessage(), e);
        }
    }

    public String chat(String message) {
        return chat(message, "You are a helpful assistant.");
    }
}
