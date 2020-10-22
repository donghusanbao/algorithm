package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Code219_ContainsDup2 {
    public class Node {
        public int val;
        public int index;
        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.val != b.val ? a.val - b.val : a.index - b.index;
        }
    }
    //方法一，通过排序，时间复杂度nlogn,98.63% 70.46%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        int n = nums.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes, new NodeComparator());
        for (int i = 0; i < n - 1; i++) {
            if (nodes[i].val == nodes[i + 1].val) {
                if (nodes[i + 1].index - nodes[i].index <= k) {
                    return true;
                }
            }
        }
        return false;
    }
    //方法二 哈希表 97.26% 
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int oldIndex = map.get(nums[i]);
                if (i - oldIndex <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
