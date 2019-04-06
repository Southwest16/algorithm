package leetcode.dynamic;

/**
 * Buy and sell stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BuySellStock {
    public static int maxprofit(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;

        for (int p : prices) {
            release1 = Math.max(release1, hold1 + p);
            release2 = Math.max(release2, hold2 + p);

            hold1 = Math.max(hold1, -p);
            hold2 = Math.max(hold2, release1 - p);
        }
        return release2;
    }
}
