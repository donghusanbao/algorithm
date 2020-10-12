package dynamic;

public class Code53_MaxSub {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxSum = new int[nums.length];
        int end = maxSum.length - 1;
        maxSum[end] = nums[end];
        int max = maxSum[end];
        for (int i = end - 1; i >= 0; i--) {
            maxSum[i] = Math.max(nums[i], nums[i] + maxSum[i + 1]);
            if (maxSum[i] > max) {
                max = maxSum[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(array);
    }
}
