package leetcode.problems;

/**
 * 买卖股票的最佳时机
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        /*for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) { //小于等于i的所有元素中的最小值
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) { //第i天的股票价格 - 之前的最小价格
                maxProfit = prices[i] - minPrice;
            }
        }*/

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
