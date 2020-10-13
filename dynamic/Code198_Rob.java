package dynamic;

public class Code198_Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] take = new int[n];
        int[] untake = new int[n];
        take[n - 1] = nums[n - 1];
        untake[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            take[i] = nums[i] + untake[i + 1];
            untake[i] = Math.max(take[i + 1], untake[i + 1]);
        }
        return Math.max(take[0], untake[0]);
    }
}
