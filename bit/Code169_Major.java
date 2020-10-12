package bit;

import java.util.Arrays;

public class Code169_Major {
    //77% 56%
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
