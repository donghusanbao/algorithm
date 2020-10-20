package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ext_GenPos {
    public static int[] getPosOrder(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }
        int[] pos = new int[n];
        process(preOrder, 0, n - 1, inOrder, 0, n - 1, pos, 0, n - 1, map);
        return pos;
    }
    public static void process(int[] preOrder, int preL, int preR, int[] inOrder, int inL, int inR,
                               int[] posOrder, int posL, int posR, Map<Integer, Integer> inTable) {
        if (preL > preR) {
            return;
        }
        if (preL == preR) {
            posOrder[posL] = preOrder[preL];
            return;
        }
        posOrder[posR] = preOrder[preL];
        int inIndex = inTable.get(preOrder[preL]);
        int leftDiff = inIndex - inL;
        process(preOrder, preL + 1, preL + leftDiff, inOrder, inL, inIndex - 1,
                posOrder, posL, posL + leftDiff - 1, inTable);
        process(preOrder, preL + leftDiff + 1, preR, inOrder, inIndex + 1,
                inR, posOrder, posL + leftDiff, posR - 1, inTable);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] preOrder = new int[num];
        int[] inOrder = new int[num];
        String[] preStr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            preOrder[i] = Integer.parseInt(preStr[i]);
        }
        String[] inStr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            inOrder[i] = Integer.parseInt(inStr[i]);
        }
        int[] pos = getPosOrder(preOrder, inOrder);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(pos[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
