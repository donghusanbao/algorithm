package dynamic;

public class Code121_MaxProfit {
    //方法一 递归方法，不满足要求，但可以修改为方法二里的动态规划
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        return process(prices, 0, false);
    }

    public int process(int[] prices, int idx, boolean sold) {
        if (idx == prices.length - 1) {
            if (!sold) {
                return 0;
            } else {
                return prices[idx];
            }
        }
        if (idx >= prices.length) {
            return 0;
        }

        if (sold) {
            return Math.max(prices[idx], process(prices, idx + 1, sold));
        } else {
            int sell = - prices[idx] + process(prices, idx + 1, true);
            int unSell = process(prices, idx + 1, false);
            return Math.max(sell, unSell);
        }
    }

    //方法二：动态规划 65%
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int sold = prices[n - 1];
        int unsold = 0;
        for (int i = n - 2; i >= 0; i--) {
            int soldlTemp = sold;
            sold = Math.max(soldlTemp, prices[i]);
            unsold = Math.max(- prices[i] + soldlTemp, unsold);
        }
        return unsold;
    }

    //方法三：更好的 99% 96%
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int dif = prices[i] - min;
                max = dif > max ? dif : max;
            }
        }
        return max;
    }


}
