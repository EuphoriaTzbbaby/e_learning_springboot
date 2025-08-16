package tzb.utils;

public class Match {
    public boolean checkContainSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else i += 1;
        }
        return j >= n;
    };
}
