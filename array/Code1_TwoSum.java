package array;

import java.util.HashMap;
import java.util.Map;

public class Code1_TwoSum {
    //99.58% 68.05% 使用哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                results[0] = map.get(target - nums[i]);
                results[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return results;
    }
}
