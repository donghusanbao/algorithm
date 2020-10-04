package binarytree;

public class Code117_Connect2 {
    public ConnectNode connect(ConnectNode root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        process(root);
        return root;
    }

    public void process(ConnectNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        ConnectNode copeNode = null;
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            copeNode = node.right;
        } else if (node.left != null && node.right == null){
            copeNode = node.left;
        } else {
            copeNode = node.right;
        }
        ConnectNode pNext = node.next;
        while (pNext != null) {
            if (pNext.left != null) {
                copeNode.next = pNext.left;
                break;
            } else if (pNext.right != null) {
                copeNode.next = pNext.right;
                break;
            } else {
                pNext = pNext.next;
            }
        }
        if (pNext == null) {
            copeNode.next = null;
        }
        process(node.right);
        process(node.left);
    }
}
