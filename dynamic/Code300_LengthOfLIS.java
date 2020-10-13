package dynamic;

public class Code300_LengthOfLIS {
    //75% 64%
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int[] take = new int[n];
        int[] untake = new int[n];
        take[n - 1] = 1;
        untake[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            untake[i] = Math.max(take[i + 1], untake[i + 1]);
            int pMax = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    pMax = Math.max(pMax, take[j]);
                }
            }
            take[i] = 1 + pMax;
        }
        return Math.max(take[0], untake[0]);
    }
}
