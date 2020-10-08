package array;

import java.util.Arrays;

public class Code16_ThreeSumClose {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0) && (nums[i] ==  nums[i - 1])) {
                continue;
            }
            int targetNew = target - nums[i];
            int third = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if ((j > i + 1) && (nums[j] == nums[j - 1])) {
                    continue;
                }

                int tmp = Integer.MAX_VALUE;
                while ((j < third) && (nums[j] + nums[third] > targetNew)) {
                    tmp = nums[j] + nums[third];
                    third--;
                }

                if (j == third) {
                    int minMax = Math.abs(targetNew - tmp);
                    if ((tmp != Integer.MAX_VALUE) && minMax < min) {
                        min = minMax;
                        sum = nums[i] + tmp;
                    }
                    break;
                }

                if (nums[j] + nums[third] == targetNew) {
                    min = 0;
                    return target;
                } else {
                    int firstMin = Math.abs(nums[j] + nums[third] - targetNew);
                    if (firstMin < min) {
                        min = firstMin;
                        sum = nums[i] + nums[third] + nums[j];
                    }
                    int minMax = Math.abs(targetNew - tmp);
                    if (tmp != Integer.MAX_VALUE) {
                        if (minMax < min) {
                            min = minMax;
                            sum = nums[i] + tmp;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
