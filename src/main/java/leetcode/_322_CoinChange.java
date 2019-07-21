package leetcode;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.com/problems/coin-change/
 */
public class _322_CoinChange {
    public static void main(String[] args) {
        int[] coins = {4, 5};
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; //走到对应下标步数所需要的零钱个数
        Arrays.fill(dp, amount+1); //填充数组
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { //走到第i个台阶
            for (int j = 0; j < coins.length; j++) { //一次要走j步
                if (coins[j] <= i) { //当前所在台阶数要大于一步要走的台阶数
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //状态转移方程
                }
            }
        }
        for (int d: dp) {
            System.out.print(d + " ");
        }
        System.out.println();
        //走到最后amount台阶需要的零钱数(如果每一步都选择走一个台阶, 最多也只需要amount步)
        //所以, 如果刚好能走到第amount个台阶, 那dp[amount]肯定会被替换成一个小于等于amount的值
        //如果不存在走到第amount个台阶的零钱组合, 那么dp[amount]就不会被替换, 还是原来的amount+1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
