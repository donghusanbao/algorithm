package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

import java.util.Stack;

public class Code783_DiffBST {
    boolean isSet;
    int min;
    int pre;

    //第一次提交 31.75% 80.36%
    public int minDiffInBST(TreeNode root) {
        boolean isSet = false;
        int pre = -1;
        int min = -1;
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();
        while ((!s.isEmpty()) || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                if (!isSet) {
                    pre = cur.val;
                    isSet = true;
                } else {
                    int dif = Math.abs(pre - cur.val);
                    if (min == -1) {
                        min = dif;
                    } else if (dif < min) {
                        min = dif;
                    }
                    pre = cur.val;
                }
                cur = cur.right;
            }
        }
        return min;
    }

    //方法二：使用递归 100% 97.08%
    public int minDiffInBST2(TreeNode root) {
        isSet = false;
        min = -1;
        pre = -1;
        process(root);
        return min;
    }

    public void process(TreeNode node) {
        if (node == null) {
            return;
        }
        process(node.left);
        if (!isSet) {
            isSet = true;
            pre = node.val;
        } else {
            int dif = Math.abs(pre - node.val);
            if (min == -1) {
                min = dif;
            } else if (dif < min) {
                min = dif;
            }
            pre = node.val;
        }
        process(node.right);
    }
}
