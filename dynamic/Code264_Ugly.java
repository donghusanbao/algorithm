package dynamic;

import java.util.HashSet;
import java.util.Set;

public class Code264_Ugly {
    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int size = 1;
        int j = 2;
        while (size != n) {
            System.out.println("size is " + size + " j is " + j);
            if (j % 2 == 0) {
                size = set.contains(j / 2) ? size + 1 : size;
                set.add(j);
            } else if (j % 3 == 0) {
                size = set.contains(j / 3) ? size + 1 : size;
                set.add(j);
            } else if (j % 5 == 0) {
                size = set.contains(j / 5) ? size + 1 : size;
                set.add(j);
            }
            j++;
        }
        return j - 1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
    }
}
