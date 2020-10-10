package bit;

import java.util.ArrayList;
import java.util.List;

public class Code78_SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            List<Integer> nullList = new ArrayList<>();
            results.add(nullList);
            return results;
        }
        int[] path = new int[nums.length];
        int pos = 0;
        int idx = 0;
        process(results, nums, idx, path, pos);
        return results;
    }

    public void process(List<List<Integer>> results, int[] nums, int idx, int[] path, int pos) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < pos; i++) {
                list.add(path[i]);
            }
            results.add(list);
            return;
        }
        process(results, nums, idx + 1, path, pos);
        path[pos] = nums[idx];
        process(results, nums, idx + 1, path, pos + 1);
    }

    public static void main(String[] args) {
        Code78_SubSet subSet = new Code78_SubSet();
        int[] array = new int[]{1, 2, 3};
        subSet.subsets(array);
    }
}
