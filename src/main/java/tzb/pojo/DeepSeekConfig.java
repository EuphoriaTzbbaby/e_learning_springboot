// DeepSeekConfig.java
package tzb.pojo;

import lombok.Data;

@Data
public class DeepSeekConfig {
    private Integer id;
    private String apiKey;
    private String baseUrl;
    private String model;
    private Integer maxTokens;
    private Double temperature;
}
