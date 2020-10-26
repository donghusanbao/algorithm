package string;

public class Code14_LongestCommonPrefix {
    //88%
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String base = strs[0];
        int end = base.length();
        for (int i = 1; i < strs.length && end > 0; i++) {
            if (strs[i] == "") {
                return "";
            }
            end = Math.min(end, strs[i].length());
            for (int j = 0; j < end; j++) {
                if (base.charAt(j) != strs[i].charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        if (end == 0) {
            return "";
        }
        return base.substring(0, end);
    }
}
