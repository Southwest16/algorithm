package leecode.dynamic;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCost = new MinCostClimbingStairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100};

        System.out.println(minCost.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        //return cost[len - 1];
        return Math.min(cost[len - 1], cost[len - 2]);
    }
}