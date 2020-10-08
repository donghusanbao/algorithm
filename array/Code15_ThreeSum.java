package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15_ThreeSum {
    //28.74% 25.65%
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            int second = i + 1;
            int third = nums.length - 1;
            int target = - nums[i];
            while (second < third) {
                if ((second > (i + 1)) && (nums[second] == nums[second - 1])) {
                    second++;
                    continue;
                }
                if ((third < (nums.length - 1)) && (nums[third] == nums[third + 1])) {
                    third--;
                    continue;
                }
                int value = nums[second] + nums[third];
                if (value > target) {
                    third--;
                } else if (value < target) {
                    second++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    results.add(list);
                    second++;
                    third--;
                }
            }
        }
        return results;
    }
}
