// ChatRequest.java
package tzb.dto;

import lombok.Data;

@Data
public class ChatRequest {
    private String message;
    private String systemPrompt;
}
