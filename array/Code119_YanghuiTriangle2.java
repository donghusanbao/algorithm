package array;

import java.util.ArrayList;
import java.util.List;

public class Code119_YanghuiTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        //rowIndex + 1为第rowIndex行的大小，因为要在数组第0位置补个0，所以大小为rowIndex + 2
        int[] result = new int[rowIndex + 1 + 1];
        //在第1个位置上置1
        result[1] = 1;
        int curRow = 1;
        int size = curRow + 1;
        //当rowIndex为0的时候，直接跳过该循环
        while (curRow <= rowIndex) {
            for (int i = size; i >= 1; i--) {
                result[i] += result[i - 1];
            }
            curRow++;
            size++;
        }
        List<Integer> list = new ArrayList<>();
        //从第1个位置开始取。
        for (int i = 1; i < size; i++) {
            list.add(result[i]);
        }
        return list;
    }
}
