// DeepSeekController.java
package tzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.dto.ChatRequest;
import tzb.dto.ChatResponse;
import tzb.service.DeepSeekService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/deepseek")
public class DeepSeekController {

    @Autowired
    private DeepSeekService deepSeekService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        System.out.println(request.toString());
        try {
            String response = deepSeekService.chat(
                    request.getMessage(),
                    request.getSystemPrompt()
            );
            return ChatResponse.success(response);
        } catch (Exception e) {
            return ChatResponse.error(e.getMessage());
        }
    }

    @GetMapping("/test")
    public ChatResponse test() {
        try {
            String response = deepSeekService.chat(
                    "你好，请用中文介绍一下你自己",
                    "你是一位友好的AI助手"
            );
            return ChatResponse.success(response);
        } catch (Exception e) {
            return ChatResponse.error(e.getMessage());
        }
    }

//    @PostMapping("/batch")
//    public List<ChatResponse> batchChat(@RequestBody ChatRequest[] requests) {
//        try {
//            List<ChatResponse> res = new ArrayList<>();
//            for (int i = 0; i < requests.length; i++) {
//                ChatRequest request = requests[i];
//                String response = deepSeekService.chat(
//                        request.getMessage(),
//                        request.getSystemPrompt()
//                );
//
//            }
//            return Collections.singletonList(ChatResponse.success(res.toString()));
//        } catch (Exception e) {
//            return Collections.singletonList(ChatResponse.error(e.getMessage()));
//        }
//    }
}
