package binarytree;

public class Code116_Connect {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.next = null;
            return root;
        }
        process(root, null);
        return root;
    }

    public void process(Node node, Node next) {
        if (node.left == null && node.right == null) {
            node.next = next;
            return;
        }

        process(node.left, node.right);
        if (next != null) {
            process(node.right, next.left);
        } else {
            process(node.right, null);
        }
        node.next = next;
    }
}
