package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ext_ColorSquare {
    public static int minColorSquare(String str) {
        int n = str.length();
        //假设当前位置为i，leftGreen代表包含i位置，左侧一共有几个绿色的正方形
        int[] leftGreen = new int[n + 2];
        //rightRed代表不包含i位置，右侧一共有几个红色正方形
        int[] rightRed = new int[n + 2];
        leftGreen[0] = 0;
        rightRed[n + 1] = 0;
        for (int i = 1; i < n + 2; i++) {
            if (i == n + 1) {
                leftGreen[i] = leftGreen[i - 1];
                continue;
            }
            leftGreen[i] = leftGreen[i - 1] + (str.charAt(i - 1) == 'R' ? 0 : 1);
        }
        for (int i = n; i >= 0; i--) {
            if (i == n) {
                rightRed[i] = rightRed[i + 1];
                continue;
            }
            rightRed[i] = rightRed[i + 1] + (str.charAt(i) == 'R' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n + 2; i++) {
            int pSum = leftGreen[i] + rightRed[i];
            System.out.println(pSum);
            if (pSum < min) {
                min = pSum;
            }
        }
        return min;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(minColorSquare(str));
    }
}
