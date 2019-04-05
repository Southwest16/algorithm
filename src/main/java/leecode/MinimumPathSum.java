package leecode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 6},
            {1, 5, 1},
            {4, 2, 1}
        };

        MinimumPathSum path = new MinimumPathSum();
        System.out.println(path.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //初始化长度为列数加一的数组
        int[] dp = new int[col + 1];

        //将矩阵的第一行放入数组dp中
        for (int j = 0; j < col; j++)
            dp[j + 1] = dp[j] + grid[0][j];
        //将数组dp的第一个元素赋值为Int最大值
        dp[0] = Integer.MAX_VALUE;

        //从第二行遍历矩阵
        for (int i = 1; i < row; i++)
            for (int j = 0; j < col; j++)
                dp[j + 1] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
        return dp[col];
    }
}
