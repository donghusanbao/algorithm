package array;

import java.util.ArrayList;
import java.util.List;

public class Code114_YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return results;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        results.add(list);
        if (numRows == 1) {
            return results;
        }
        process(numRows, 1, list, results);
        return results;
    }

    public void process(int totalRow, int curRow, List<Integer> preList, List<List<Integer>> results) {
        if (curRow == totalRow) {
            return;
        }
        int curSize = preList.size() + 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < curSize; i++) {
            if (i == 0 || i == curSize - 1) {
                list.add(1);
            } else {
                list.add(preList.get(i - 1) + preList.get(i));
            }
        }
        results.add(list);
        process(totalRow, curRow + 1, list, results);
    }
}
