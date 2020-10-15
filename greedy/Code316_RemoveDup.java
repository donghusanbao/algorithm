package greedy;

import java.util.HashSet;
import java.util.Set;

public class Code316_RemoveDup {
    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int n = str.length;
        int top = n;
        Set<Character> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(str[i])) {
                set.add(str[i]);
                top--;
                str[top] = str[i];
            } else {
                for (int j = n - 1; j >= top; j--) {
                    if (str[j] == str[i]) {
                        System.out.println("i == " + i +" j == " + j);
                        if (j != top && (str[i] < str[top])) {
                            for (int k = j; k > top; k--) {
                                str[k] = str[k - 1];
                            }
                            str[top] = str[i];
                        }
                        System.out.println(str[top]);
                        break;
                    }
                }
            }
        }
        String result = "";
        for (int i = top; i < n; i++) {
            result += str[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        removeDuplicateLetters(s);
    }
}
