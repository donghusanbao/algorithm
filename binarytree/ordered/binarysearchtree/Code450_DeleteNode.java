package binarytree.ordered.binarysearchtree;

import binarytree.TreeNode;

public class Code450_DeleteNode {
    //第一次提交 100% 68.3%
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode addParent = new TreeNode(-1);
        addParent.left = root;
        addParent.right = null;
        TreeNode node = search(root, key);
        if (node != null) {
            //第一次提交错误，java用引用传递
            TreeNode parent = findParent(root, key, addParent);
            if (node.left == null) {
                if (node.right == null) {
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else {
                    if (parent.left == node) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                }
            } else {
                if (node.right == null) {
                    if (parent.left == node) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {
                    TreeNode successor = getMinimal(node.right);
                    TreeNode rParent = findParent(node.right, successor.val, node);
                    if (successor != node.right) {
                        if (successor == rParent.left) {
                            rParent.left = successor.right;
                        } else {
                            rParent.right = successor.right;
                        }
                        successor.right = node.right;
                    }
                    successor.left = node.left;
                    if (node == parent.left) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
            }
        }
        //第二次提交错误，当key找不到时，应该返回原二叉树

        return addParent.left;
    }

    public TreeNode search(TreeNode node, int key) {
        while (node != null && node.val != key) {
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    public TreeNode findParent(TreeNode node, int key, TreeNode addParent) {
        TreeNode cur = addParent;
        while (node != null && node.val != key) {
            cur = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return cur;
    }

    public TreeNode getMinimal(TreeNode node) {
        TreeNode cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    //第二次提交，利用递归 100% 71.86%
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode node = search(root, key);
        if (node != null){
            node = process(root, key);
        } else {
            return root;
        }
        return node;
    }

    public TreeNode process(TreeNode node, int key) {
        if (node.val > key) {
            node.left = process(node.left, key);
        } else if (node.val < key) {
            node.right = process(node.right, key);
        } else {
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.right == null && node.left != null) {
                return node.left;
            } else {
                TreeNode pre = null;
                TreeNode cur = node.right;
                while (cur.left != null) {
                    pre = cur;
                    cur = cur.left;
                }
                if (pre != null) {
                    pre.left = cur.right;
                    cur.right = node.right;
                }
                cur.left = node.left;
                return cur;
            }
        }
        return node;
    }
}
