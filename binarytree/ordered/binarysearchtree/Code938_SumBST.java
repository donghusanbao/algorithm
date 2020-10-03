package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

public class Code938_SumBST {
    //100% 17.35%
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= L && root.val <= R) {
            count += root.val;
            count += rangeSumBST(root.left, L, R);
            count += rangeSumBST(root.right, L, R);
        } else if (root.val > L) {
            count += rangeSumBST(root.left, L, R);
        } else {
            count += rangeSumBST(root.right, L, R);
        }
        return count;
    }
}
