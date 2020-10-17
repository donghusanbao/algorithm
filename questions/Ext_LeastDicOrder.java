package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ext_LeastDicOrder {
    public static class DicComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s1.compareTo(s2);
        }
    }
    public static String leastDictorySeq(String[] strs) {
        Arrays.sort(strs, new DicComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arrays = new String[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = br.readLine();
        }
        System.out.print(leastDictorySeq(arrays));
    }
}
