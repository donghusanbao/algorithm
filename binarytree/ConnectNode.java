package binarytree;

public class ConnectNode {
    public int val;
    public ConnectNode left;
    public ConnectNode right;
    public ConnectNode next;

    public ConnectNode() {}

    public ConnectNode(int _val) {
        val = _val;
    }

    public ConnectNode(int _val, ConnectNode _left, ConnectNode _right, ConnectNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
