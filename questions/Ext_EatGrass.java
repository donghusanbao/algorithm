package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ext_EatGrass {
    public static String winner(int n) {
        if (n < 5) {
            //0 后手 1 先手 2 后手 3 先手 4 先手
            if (n == 1 || n == 3 || n == 4) {
                return "先手";
            } else {
                return "后手";
            }
        }
        int base = 1;
        while (base <= n) {
            if (winner(n - base) == "后手") {
                return "先手";
            }
            base *= 4;
        }
        return "后手";
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int groupNum = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] data = new int[groupNum];
        for (int i = 0; i < groupNum; i++) {
            data[i] = Integer.parseInt(br.readLine().split(" ")[0]);
        }
        //最好在打印任何数据前先把所有的输入数据处理过程完成
        for (int i = 0; i < groupNum; i++) {
            if ((data[i] % 5) == 0 || (data[i] % 5) == 2) {
                System.out.println("yang");
            } else {
                System.out.println("niu");
            }
        }
    }
}
