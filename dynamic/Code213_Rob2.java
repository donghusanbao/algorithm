package dynamic;

public class Code213_Rob2 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int n = nums.length;
        int take = nums[n - 1] + process(nums, 1, n - 3);
        System.out.println(take);
        int untake = process(nums, 0, n - 2);
        System.out.println(untake);
        return Math.max(take, untake);
    }

    public static int process(int[] nums, int left, int right) {
        System.out.println("=========== left is " + left + "   right is " + right);
        int n = right - left + 1;
        int[] take = new int[n];
        int[] untake = new int[n];
        take[n - 1] = nums[right];
        untake[n - 1] = 0;
        int index = 1;
        for (int i = n - 2; i >= 0; i--) {
            take[i] = nums[right - index] + untake[i + 1];
            untake[i] = Math.max(take[i + 1], untake[i + 1]);
            System.out.println("take is " + take[i] + " untake is " + untake[i] + " nums is " + nums[right - index]);
            //index 错误
            index++;
        }
        return Math.max(take[0], untake[0]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 1, 3, 100};
        System.out.println(rob(prices));
    }
}
