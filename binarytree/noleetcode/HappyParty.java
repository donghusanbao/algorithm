package binarytree.noleetcode;

import binarytree.TreeNode;

public class HappyParty {
    public int getMaxHappy(TreeNode head) {
        return process(head, false);
    }

    public int process(TreeNode node, boolean join) {
        if (node == null) {
            return 0;
        }
        int leftNo = process(node.left, false);
        int rightNo = process(node.right, false);
        if (join) {
            return leftNo + rightNo;
        } else {
            int noJoin = leftNo + rightNo;
            int leftYes = process(node.left, true);
            int rightYes = process(node.right, true);
            int yesJoin = leftYes + rightYes + node.val;
            return Math.max(noJoin, yesJoin);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(13);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(10);
        node3.right = node6;
        HappyParty happyParty = new HappyParty();
        System.out.println(happyParty.getMaxHappy(node1));

    }
}
