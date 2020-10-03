package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

public class Code700_Search {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
