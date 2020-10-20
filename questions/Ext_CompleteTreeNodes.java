package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ext_CompleteTreeNodes {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int totalLevel = getDeep(head);
        return getNodeNum(head, 1, totalLevel);
    }
    public int getDeep(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public int getNodeNum(TreeNode node, int curLevel, int totalLevel) {
        if (curLevel == totalLevel) {
            return node == null ? 0 : 1;
        }
        int sum = 0;
        int rightDeep = getDeep(node.right);
        if (rightDeep == (totalLevel - curLevel)) {
            sum += (1 << (totalLevel - curLevel));
            sum += getNodeNum(node.right, curLevel + 1, totalLevel);
        } else {
            sum += (1 << (totalLevel - curLevel - 1));
            sum += getNodeNum(node.left, curLevel + 1,totalLevel);
        }
        return sum;
    }
}
