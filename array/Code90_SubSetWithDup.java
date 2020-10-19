package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code90_SubSetWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        int[] path = new int[nums.length];
        process(nums, 0, results, path, 0);
        return results;
    }

    public static void process(int[] nums, int pos, List<List<Integer>> results, int[] path, int pathPos) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < pathPos; i++) {
                list.add(path[i]);
            }
            results.add(list);
            return;
        }
        int index = pos;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                break;
            } else {
                index++;
            }
        }
        System.out.println(index);
        process(nums, index, results, path, pathPos);
        path[pathPos] = nums[pos];
        process(nums, pos + 1, results, path, pathPos + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2};
        subsetsWithDup(array);
    }
}
