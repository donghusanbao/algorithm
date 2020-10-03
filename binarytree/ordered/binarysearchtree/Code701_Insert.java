package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

public class Code701_Insert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            cur = cur.val > val ? cur.left : cur.right;
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }
}
