package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ext_CompleteStr {
    public static boolean isCompletedString(String str) {
        char[] s = str.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '(' && s[i] != ')') {
                return false;
            } else if (s[i] == '(') {
                count++;
            } else {
                count--;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0 ? true : false;
    }

    public static int addNums(String s) {
        if (s == null || s == "") {
            return 0;
        }
        char[] str = s.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                count++;
            } else if (str[i] == ')') {
                count--;
                if (count < 0) {
                    need++;
                    count = 0;
                }
            }
        }
        need += count;
        return need;
    }

    public static int getLongest(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int n = s.length;
        int[] lengths = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != '(' && i > 0) {
                int pre = i - lengths[i - 1] - 1;
                if (pre >= 0 && s[pre] == '(') {
                    lengths[i] = lengths[i - 1] + 2;
                    if (pre > 0) {
                        lengths[i] += lengths[pre - 1];
                    }
                    max = Math.max(max, lengths[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str + " " + (isCompletedString(str) ? "yes" : "no"));
        System.out.println(addNums(str));
        System.out.println(getLongest(str));
    }
}
