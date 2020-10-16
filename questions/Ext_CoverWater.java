package questions;

import java.util.PriorityQueue;

public class Ext_CoverWater {
    public static long coverWater(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        long water = 0;
        int l = 0, r = n - 1, leftMost = -1, rightMost = -1;
        while (l <= r) {
            if (leftMost <= rightMost) {
                if (leftMost > array[l]) {
                    water += (leftMost - array[l++]);
                } else {
                    leftMost = array[l++];
                }
            } else {
                if (rightMost > array[r]) {
                    water += (rightMost - array[r--]);
                } else {
                    rightMost = array[r--];
                }
            }
        }
        return water;
    }
}
