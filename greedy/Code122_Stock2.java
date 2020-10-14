package greedy;

public class Code122_Stock2 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int profit = 0;
        int i = 0;
        while (i < n) {
            int valley = prices[i];
            for (int j = i; j < n - 1; j++) {
                if (prices[j] >= prices[j + 1]) {
                    valley = prices[j + 1];
                    i++;
                    System.out.println("=====");
                    System.out.println(j);
                } else {
                    System.out.println("else + " + j);
                    break;
                }
            }
            int peak = valley;
            for (int j = i; j < n - 1; j++) {
                if (prices[j] <= prices[j + 1]) {
                    System.out.println("*******");
                    System.out.println(prices[j]);
                    peak = prices[j + 1];
                    i++;
                    System.out.println("----------");
                    System.out.println(j);
                } else {
                    break;
                }
            }
            System.out.println("===== " + peak + ":" + valley);
            profit += (peak - valley);
            i++;

        }
        return profit;
    }
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int profit = 0;
        int i = 0;
        while (i < n) {
            int valley = prices[i];
            for (int j = i; j < n - 1; j++) {
                if (prices[j] >= prices[j + 1]) {
                    valley = prices[j + 1];
                    i++;
                } else {
                    break;
                }
            }
            int peak = prices[i];
            for (int j = i; j < n - 1; j++) {
                if (prices[j] <= prices[j + 1]) {
                    peak = prices[j + 1];
                    i++;
                } else {
                    break;
                }
            }
            profit += (peak - valley);
            //第一次提交漏写了 i++
            i++;

        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        maxProfit(array);
    }
}
