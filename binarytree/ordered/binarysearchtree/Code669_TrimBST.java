package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

public class Code669_TrimBST {
    //100% 70.71%
    public TreeNode trimBST(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }
        if (node.val >= low && node.val <= high) {
            node.left = trimBST(node.left, low, high);
            node.right = trimBST(node.right, low, high);
        } else {
            node = node.val < low ? node.right : node.left;
            node = trimBST(node, low, high);
        }
        return node;
    }
}
