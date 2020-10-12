package dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_WordBreak {
    //没有使用substring函数，性能5%
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        char[] str = s.toCharArray();
        int length = str.length;
        boolean[] results = new boolean[length + 1];
        for (int i = 0; i <= length - 1; i++) {
            results[i] = false;
        }
        results[length] = true;
        for (int i = length - 1; i >= 0; i--) {
            String part = "";
            System.out.println(" i is " + i);
            for (int j = i; j <= (length - 1); j++) {
                part += str[j];
                System.out.println("part is " + part);
                if (results[j + 1]) {
                    System.out.println("i is " + i + " j is " + j);
                    if (set.contains(part)) {
                        results[i] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < length - 1; i++) {
            System.out.println(results[i]);
        }
        return results[0];
    }

    //使用了substring，87% 72%
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] results = new boolean[length + 1];
        results[length] = true;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j <= (length - 1); j++) {
                if (results[j + 1]) {
                    if (set.contains(s.substring(i, j + 1))) {
                        results[i] = true;
                        break;
                    }
                }
            }
        }
        return results[0];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak(str, list));

    }
}
