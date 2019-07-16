package learn.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.com/problems/coin-change
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinChange coin = new CoinChange();
        System.out.println(coin.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // dp数组全部填充为amount+1
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        // 将每一步的最小值赋值给dp数组对应下标的值
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
        // 如果dp数组中存在没有赋值成功的元素,
        // 就表明不存在这样的零钱组合, 使得等于amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
