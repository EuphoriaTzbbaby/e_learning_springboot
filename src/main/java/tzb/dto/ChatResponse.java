// ChatResponse.java
package tzb.dto;

public class ChatResponse {
    private boolean success;
    private String data;
    private String error;

    // 构造方法、getter、setter
    public ChatResponse() {}

    public ChatResponse(boolean success, String data) {
        this.success = success;
        this.data = data;
    }

    public ChatResponse(boolean success, String data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static ChatResponse success(String data) {
        return new ChatResponse(true, data);
    }

    public static ChatResponse error(String error) {
        return new ChatResponse(false, null, error);
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
