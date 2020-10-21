package array;

public class Code209_MinSubArrayLength {
    //方法一 nlogn
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (nums[0] >= s) {
            return 1;
        }
        int[] accum = new int[n];
        accum[0] = nums[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= s) {
                return 1;
            } else {
                int dif = s - nums[i];
                if (accum[i - 1] >= dif) {
                    //找到第一个大于val的点的索引(不包含等于)
                    int val = accum[i - 1] - dif;
                    int index = find(accum, val, 0, i - 1);
                    int length = i - index + 1;
                    if (length < min) {
                        min = length;
                    }
                }
                accum[i] = accum[i - 1] + nums[i];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int find(int[] nums, int val, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //方法二 双指针
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        int pSum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n && (left <= right)) {
            pSum += nums[right];
            if (pSum >= s) {
                min = Math.min(min, right - left + 1);
                pSum -= nums[left++];
                pSum -= nums[right];
            } else {
                right++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
