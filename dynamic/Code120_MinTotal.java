package dynamic;

import java.util.ArrayList;
import java.util.List;

public class Code120_MinTotal {
    //95% 89%
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int level = triangle.size();
        int maxSize = triangle.get(level - 1).size();
        int[] total = new int[maxSize];
        int curSize = maxSize;
        int curLevel = level - 1;
        for (int i = 0; i < curSize; i++) {
            total[i] = triangle.get(curLevel).get(i);
        }
        curLevel--;
        curSize--;
        for (int i = curLevel; i >= 0; i--) {
            int tmp = total[curSize];
            for (int j = curSize - 1; j >= 0; j--) {
                int curTemp = total[j];
                total[j] = triangle.get(i).get(j) + Math.min(total[j], tmp);
                tmp = curTemp;
            }
            String s = "";
            for (int k = 0; k < curSize; k++) {
                s += total[k];
            }
            System.out.println(s);
            curSize--;
        }
        return total[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        minimumTotal(triangle );
    }
}
