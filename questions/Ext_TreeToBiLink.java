package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ext_TreeToBiLink {
    public class Node {
        public Node left;
        public Node right;
        public int val;
        public Node(int val) {
            this.val = val;
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
    public Info bidirectionLink(Node node) {
        if (node == null) {
            return new Info(null, null);
        }
        Info leftInfo = bidirectionLink(node.left);
        Info rightInfo = bidirectionLink(node.right);
        if (leftInfo.max != null) {
            leftInfo.max.right = node;
            node.left = leftInfo.max;
        } else {
            node.left = null;
        }

        if (rightInfo.min != null) {
            node.right = rightInfo.min;
            rightInfo.min.left = node;
        } else {
            node.right = null;
        }
        return new Info((leftInfo.min == null ? node : leftInfo.min),
                (rightInfo.max == null ? node : rightInfo.max));
    }
    public Node copeData(int[][] data, int num) {
        Map<Integer, Node> map = new HashMap<>();
        Node head = null;
        for (int i = 0; i < num; i++) {
            int nodeVal = data[i][0];
            Node root = null;
            if (i == 0) {
                root = new Node(nodeVal);
                head = root;
            } else {
                root = map.get(nodeVal);
            }
            int leftVal = data[i][1];
            int rightVal = data[i][2];
            if (leftVal != 0) {
                Node left = new Node(leftVal);
                map.put(leftVal, left);
                root.left = left;
            }
            if (rightVal != 0) {
                Node right = new Node(rightVal);
                map.put(rightVal, right);
                root.right = right;
            }
        }
        Info info = bidirectionLink(head);
        return info.min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] data = new int[num][3];
        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(str[0]);
            data[i][1] = Integer.parseInt(str[1]);
            data[i][2] = Integer.parseInt(str[2]);
        }
        Ext_TreeToBiLink process = new Ext_TreeToBiLink();
        Node node = process.copeData(data, num);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val + " ");
            node = node.right;
        }
        System.out.println(sb.toString().trim());
    }
}
