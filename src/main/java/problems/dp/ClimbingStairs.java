package problems.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    private int sum = 0;
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        /*System.out.println(cs.climbStairs01(0, 10));
        System.out.println(cs.sum);*/

        /*int[] memo = new int[11];
        System.out.println(cs.climbStairs02(0, 10, memo));
        System.out.println(cs.sum);*/

        //System.out.println(cs.climbStairs03(10));
        //System.out.println(cs.climbStairs04(10));

        System.out.println(cs.climbStairs06(10));

    }

    //斐波那契数, 时间复杂度O(n), 空间复杂度O(1)
    public int climbStairs04(int n) {
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //斐波那契通项公式. 时间复杂度O(logn), 空间复杂度O(1)
    public int climbStairs06(int n) {
        double sqrt = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return (int) (fibn / sqrt);
    }

    /** Dynamic Programming */
    public int climbStairs03(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //时间复杂度O(N), 空间复杂度O(N)
    public int climbStairs02(int i, int n, int[] memo) {
        if (i > n) return 0;    //最后一个台阶
        if (i == n) return 1;   //倒数第二个台阶

        return memo[i] > 0
                ? memo[i]
                : (memo[i] = climbStairs02(i + 1, n, memo) + climbStairs02(i + 2, n, memo));
    }

    /**
     * 递归函数。时间复杂度：2的N次方
     * @param i 当前所在的台阶。i第一步是从0开始的
     * @param n 台阶数
     * @return
     */
    public int climbStairs01(int i, int n) {
        if (i > n) return 0;    //最后一个台阶
        if (i == n) return 1;   //倒数第二个台阶

        sum += 1;
        return climbStairs01(i + 1, n) + climbStairs01(i + 2, n);
    }
}
