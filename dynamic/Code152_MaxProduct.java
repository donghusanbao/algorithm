package dynamic;

public class Code152_MaxProduct {
    public int max;
    //超出时间限制 182/187
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        process(nums, 0, 1, true);
        return max;
    }
    public int process(int[] nums, int idx, int value, boolean newOne) {
        if (idx == nums.length - 1) {
            if (newOne) {
                //本地结算
                max = Math.max(max, nums[idx]);
                return -1;
            } else {
                //非本地结算
                return Math.max(value, value * nums[idx]);
            }
        }

        if (newOne) {
            //本地结算，不用返回

            //只有当前值
            max = Math.max(max, nums[idx]);
            //当前值加后面的
            max = Math.max(max, process(nums, idx + 1, nums[idx], false));
            //不要当前值,不在本地结算，第三个参数随意
            process(nums, idx + 1, 1, true);
            return -1;
        } else {
            //非本地结算

            //不要当前值、要当前值不要后序的、要当前值也要后序的
            int pMax = Math.max(value, value * nums[idx]);
            int curMax = Math.max(pMax, process(nums, idx + 1, value * nums[idx], false));

            //不要当前，另起新的，但不在此处结算
            process(nums, idx + 1, 1, true);

            return curMax;
        }
    }
    //动态规划
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int big = nums[n - 1];
        int small = nums[n - 1];
        int max = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                big = 0;
                small = 0;
            } else {
                int bigProduct = big * nums[i];
                int smallProduct = small * nums[i];
                big = Math.max(Math.max(bigProduct, smallProduct), nums[i]);
                small = Math.min(Math.min(bigProduct, smallProduct), nums[i]);
            }
            if (big > max) {
                max = big;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, -2, 4};
        Code152_MaxProduct maxProduct = new Code152_MaxProduct();
        System.out.println(maxProduct.maxProduct2(array));
    }
}
