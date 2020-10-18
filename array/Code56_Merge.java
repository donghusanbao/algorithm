package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code56_Merge {
    //92.19% 98%
    public static class Node {
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node1.start == node2.start ? (node2.end - node1.end) : (node1.start - node2.start);
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        int m = intervals.length;
        Node[] nodes = new Node[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(nodes, new NodeComparator());
        List<Node> results = new ArrayList<>();
        Node pre = nodes[0];
        for (int i = 1; i < m; i++) {
            //start相同，不用处理，因为排序后end更大的排在前面
            if (nodes[i].start > pre.end) {
                results.add(pre);
                pre = nodes[i];
            } else if (nodes[i].start <= pre.end && (nodes[i].end > pre.end)) {
                pre.end = nodes[i].end;
            }
        }
        //不要忘了最后一个
        results.add(pre);
        int[][] array = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            array[i][0] = results.get(i).start;
            array[i][1] = results.get(i).end;
        }
        return array;
    }
}
