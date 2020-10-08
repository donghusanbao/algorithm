package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code18_FourSum {
    //常规方法 57% 51%
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < (length - 1); i++) {
            if ((i > 0) && (nums[i] ==  nums[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < (length - 1); j++) {
                if ((j > i + 1) && (nums[j] ==  nums[j - 1])) {
                    continue;
                }

                int newTarget = target - nums[i] - nums[j];
                int fourth = length - 1;

                for (int k = j + 1; k < (length - 1); k++) {
                    if ((k > j + 1) && (nums[k] ==  nums[k - 1])) {
                        continue;
                    }

                    while ((k < fourth) && (nums[k] + nums[fourth] > newTarget)) {
                        fourth--;
                    }

                    if (k == fourth) {
                        break;
                    }
                    int half = nums[k] + nums[fourth];
                    if (half == newTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[fourth]);
                        results.add(list);
                    }
                }
            }
        }
        return results;
    }
    //根据官方方法进行细节优化 99% 40%
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < (length - 3); i++) {
            if ((i > 0) && (nums[i] ==  nums[i - 1])) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < (length - 2); j++) {
                if ((j > i + 1) && (nums[j] ==  nums[j - 1])) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int newTarget = target - nums[i] - nums[j];
                int fourth = length - 1;

                for (int k = j + 1; k < (length - 1); k++) {
                    if ((k > j + 1) && (nums[k] ==  nums[k - 1])) {
                        continue;
                    }

                    while ((k < fourth) && (nums[k] + nums[fourth] > newTarget)) {
                        fourth--;
                    }

                    if (k == fourth) {
                        break;
                    }
                    int half = nums[k] + nums[fourth];
                    if (half == newTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[fourth]);
                        results.add(list);
                    }
                }
            }
        }
        return results;
    }
}
