package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code40_CombineSum2 {
    //88% 99%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        process(results, candidates, target, path, 0);
        return results;
    }
    public void process(List<List<Integer>> results, int[] candidates, int target, List<Integer> path, int idx) {
        if (target == 0) {
            results.add(new ArrayList(path));
            return;
        }
        if (idx >= candidates.length) {
            return;
        }
        if (candidates[idx] <= target) {
            path.add(candidates[idx]);
            process(results, candidates, target - candidates[idx], path, idx + 1);
            path.remove(path.size() - 1);
            int cur = idx + 1;
            while (cur < candidates.length) {
                if (candidates[cur] != candidates[idx]) {
                    process(results, candidates, target, path, cur);
                    break;
                }
                cur++;
            }
        }
    }
}
