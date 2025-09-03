package tzb.utils;

public class StringSplitter {

    /**
     * 将字符串按 空格、/、... 分割
     * @param input 要处理的字符串
     * @return 分割后的字符串数组
     */
    public static String[] splitByCustomDelimiters(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        // 使用正则：空格 或 / 或 ...
        String[] parts = input.split("\\s+|\\/|\\.\\.\\.");

        // 可选：过滤掉空字符串
        return java.util.Arrays.stream(parts)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    // 测试用例
    public static void main(String[] args) {
        String input = "hello   world/this...is a/test...string";
        String[] result = splitByCustomDelimiters(input);
        for (String s : result) {
            System.out.println("[" + s + "]");
        }
    }
}
