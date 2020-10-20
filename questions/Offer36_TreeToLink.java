package questions;

public class Offer36_TreeToLink {
    //双向循环链表！！！注意到有个“循环”
    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public class Info {
        public Node min;
        public Node max;
        public Info(Node min, Node max) {
            this.min = min;
            this.max = max;
        }
    }
    public Node treeToDoublyList(Node root) {
        Info info = process(root);
        Node left = info.min;
        Node right = info.max;
        if (left == null) {
            //第一次提交错误，只要min有数值，max必定有数值，min为空，max必为空
            return null;
        } else {
            //第二次提交错误，只有一个节点的情况，left和right指针都指向自己
            left.left = right;
            right.right = left;
            return left;
        }
    }
    public Info process(Node node) {
        if (node == null) {
            return new Info(null, null);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        if (leftInfo.max != null) {
            leftInfo.max.right = node;
            node.left = leftInfo.max;
        } else {
            node.left = null;
        }
        if (rightInfo.min != null) {
            rightInfo.min.left = node;
            node.right = rightInfo.min;
        } else {
            node.right = null;
        }
        return new Info((leftInfo.min == null ? node : leftInfo.min),
                (rightInfo.max == null ? node : rightInfo.max));
    }

    public void test() {
        Node node0 = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        Node result = treeToDoublyList(node0);
        while (result != null) {
            System.out.println(result.val);
            result = result.left;
        }
    }

    public static void main(String[] args) {
        Offer36_TreeToLink offer36_treeToLink = new Offer36_TreeToLink();
        offer36_treeToLink.test();
    }
}
