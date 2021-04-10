package leetcode.problems;

/**
 * 最小花费爬楼梯
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class _746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }

        return Math.min(cost[n-1], cost[n-2]);
    }
}
