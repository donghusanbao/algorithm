package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Code222_CompleteTreeCount {
    //第一次提交：11.70% 42.39%
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            count++;
            if (node.left != null && node.right != null) {
                nodes.add(node.left);
                nodes.add(node.right);
            } else {
                if (node.left == null) {
                    return count * 2 - 1;
                } else {
                    return count * 2;
                }
            }
        }
        return count;
    }
}
