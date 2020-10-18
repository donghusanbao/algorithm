package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ext_Shopping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int groupNums = Integer.parseInt(br.readLine());
        for (int i = 0; i < groupNums; i++) {
            String[] entries = br.readLine().split(" ");
            int goodsNum = Integer.parseInt(entries[0]);
            System.out.println("goodsNum is " + goodsNum);
            int shippers = Integer.parseInt(entries[1]);
            System.out.println("shipper is " + shippers);
            Integer[] results = new Integer[goodsNum];
            int chairs = 0;
            int chairSum = 0;
            for (int j = 0; j < goodsNum; j++) {
                String[] entry = br.readLine().split(" ");
                int perCost = Integer.parseInt(entry[0]);
                int chair = Integer.parseInt(entry[1]);
                if (chair == 1) {
                    chairSum += perCost;
                    results[j] = 0;
                    chairs++;
                } else {
                    results[j] = perCost;
                }
                System.out.println("===========");
            }
            for (int j = 0; j < goodsNum; j++) {
                System.out.println(results[j]);
            }
            Arrays.sort(results, Collections.reverseOrder());
            chairs = Math.min(chairs, shippers);
            float sum = 0;
            for (int j = 0; j < chairs; j++) {
                sum += (results[j] / 2.0);
            }
            for (int j = chairs; j < results.length; j++) {
                sum += results[j];
            }
            sum += chairSum;
            System.out.println(sum);
        }
    }
}
