package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code39_CombineSum {
    //方法一：99.94% 43.88%
    public List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        int left = 0;
        int right = candidates.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (candidates[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int end = -1;
        if (right == -1) {
            return results;
        } else if (left == candidates.length) {
            end = candidates.length - 1;
        } else {
            if (candidates[left] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                results.add(list);
            }
            end = right;
        }
        int[] path = new int[500];
        System.out.println(end);
        process(candidates, target, 0, end, path, 0);
        return results;
    }

    public void process(int[] nums, int target, int start, int end, int[] path, int pos) {
        if (start > end) {
            return;
        }
        if (nums[start] == target) {
            List<Integer> list = new ArrayList<>();
            path[pos] = nums[start];
            String printResult = "";
            for(int i = 0; i <= pos; i++) {
                list.add(path[i]);
                printResult = printResult + "+" + path[i];
            }
            System.out.println(printResult);
            results.add(list);
            return;
        }
        if (nums[start] > target) {
            return;
        }

        //nums[start] < target
        System.out.println("===================== start is ============ " + nums[start]);
        int count = target / nums[start];
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j < i; j++) {
                path[pos + j] = nums[start];
            }
            System.out.println("start is " + nums[start] + " i is " + i);
            if (target == i * nums[start]) {
                List<Integer> list = new ArrayList<>();
                String printResult = "";
                for(int k = 0; k <= (pos + i - 1); k++) {
                    list.add(path[k]);
                    printResult = printResult + "+" + path[k];
                }
                System.out.println(printResult);
                results.add(list);
            } else {
                process(nums, target - i * nums[start], start + 1, end, path, pos + i);
            }
        }

        //process(nums, target, start + 1, end, path, pos);
        //path[pos] = nums[start];
        //process(nums, target - nums[start], start, end, path ,pos + 1);
        //process(nums, target - nums[start], start + 1, end, path, pos + 1);
    }

    //官方方法 87.68% 20.72%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        int[] path = new int[500];
        process(candidates, target, 0, path, results, 0);
        return results;
    }

    public void process(int[] candidates, int target, int posPath, int[] path, List<List<Integer>> results, int idx) {
        if (target == 0) {
            List<Integer> list = new ArrayList<Integer>();
            String resultPrint = "";
            for (int i = 0; i < posPath; i++) {
                list.add(path[i]);
                resultPrint = resultPrint + "=" + path[i];
            }
            System.out.println(resultPrint);
            results.add(list);
            return;
        }

        if (idx >= candidates.length) {
            return;
        }

        process(candidates, target, posPath, path, results, idx + 1);
        if (candidates[idx] <= target) {
            path[posPath] = candidates[idx];
            process(candidates, target - candidates[idx], posPath + 1, path, results, idx);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5};
        Code39_CombineSum combineSum = new Code39_CombineSum();
        combineSum.combinationSum2(array, 10);
    }
}
