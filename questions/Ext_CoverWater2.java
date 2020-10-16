package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ext_CoverWater2 {
        public static class Node {
            int val;
            int r;
            int c;
            public Node(int val, int r, int c) {
                this.val = val;
                this.r = r;
                this.c = c;
            }
        }
        public static class NodeComparator implements Comparator<Node> {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.val - node2.val;
            }
        }
        public static int coverWater(Node[][] heights, int row, int col) {
            if (heights == null || heights.length == 0 || heights[0].length == 0) {
                return 0;
            }
            PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
            boolean[][] used = new boolean[row][col];
            int water = 0;
            for (int i = 0; i < col - 1; i++) {
                heap.add(heights[0][i]);
                used[0][i] = true;
            }
            for (int i = 0; i < row - 1; i++) {
                heap.add(heights[i][col - 1]);
                used[i][col - 1] = true;
            }
            for (int i = 1; i < col; i++) {
                heap.add(heights[row - 1][i]);
                used[row - 1][i] = true;
            }
            for (int i = 1; i < row; i++) {
                heap.add(heights[i][0]);
                used[i][0] = true;
            }
            int max = 0;
            while (!heap.isEmpty()) {
                Node node = heap.poll();
                max = Math.max(max, node.val);
                int r = node.r;
                int c = node.c;
                if (r > 0 && (!used[r - 1][c])) {
                    water += Math.max(0, max - heights[r - 1][c].val);
                    heap.add(heights[r - 1][c]);
                    used[r - 1][c] = true;
                }
                if (r < row - 1 && (!used[r + 1][c])) {
                    water += Math.max(0, max - heights[r + 1][c].val);
                    heap.add(heights[r + 1][c]);
                    used[r + 1][c] = true;
                }
                if (c > 0 && (!used[r][c - 1])) {
                    water += Math.max(0, max - heights[r][c - 1].val);
                    heap.add(heights[r][c - 1]);
                    used[r][c - 1] = true;
                }
                if (c < col - 1 && (!used[r][c + 1])) {
                    water += Math.max(0, max - heights[r][c + 1].val);
                    heap.add(heights[r][c + 1]);
                    used[r][c + 1] = true;
                }
            }
            return water;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            Node[][] nodes = new Node[row][col];
            for (int i = 0; i < row; i++) {
                String[] lines = br.readLine().split(" ");
                nodes[i] = new Node[col];
                for (int j = 0; j < col; j++) {
                    nodes[i][j] = new Node(Integer.parseInt(lines[j]), i, j);
                }
            }
            int water = coverWater(nodes, row, col);
            System.out.println(water);
        }
}
