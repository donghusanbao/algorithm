package questions;

public class Code_Overlap {
    //动态规划解 复杂度length * N
    public static int getMostNode(int[] array, int length) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int[] results = new int[length + 1];
        for (int i = 0; i < length + 1; i++) {
            results[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int dif = array[i + 1] - array[i];
            for (int j = length; j >= 0; j--) {
                if (j < dif) {
                    continue;
                }
                results[j] = Math.max(results[j], results[j - dif] + 1);
            }
        }
        return results[length];
    }

    //二分方法
    public static int getMostNode2(int[] array, int length) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int diff = array[i] - length;
            int left = 0;
            //i位置一定会大于等于，所以最差的情况也是i
            int right = i;
            while (left <= right) {
                int mid = left + ((right - left) >> 2);
                if (array[mid] >= diff) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int num = i - left + 1;
            max = Math.max(max, num);
        }
        return max;
    }

    //贪心算法,双指针L和R


    public static void main(String[] args) {
        int[] array = {2, 7, 15, 19, 23};
        int L = 8;
        System.out.println(getMostNode(array, L));
    }
}
