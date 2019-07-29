package leetcode;

/**
<<<<<<< HEAD
 * 最小路径和
=======
 * 矩阵最小路径和
>>>>>>> 0acc98ca3d2b2a64b5a2c82f2fbb8682a578b93f
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class _64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}};

        System.out.println(minPathSum(grid));
    }

    //时间复杂度O(n²), 空间复杂度O(1)
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1) return 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[row-1][col-1];
    }

    //状态转移表法, 从左上角到右下角.
    //时间复杂度O(n²), 空间复杂度O(n²)
    public int minPathSum2(int[][] grid, int n) {
        int[][] state = new int[n][n];
        int sum = 0;
        for (int col = 0; col < n; col++) {
            sum += grid[0][col];
            state[0][col] = sum;
        }

        sum = 0;
        for (int row = 0; row < n; row++) {
            sum += grid[row][0];
            state[row][0] = sum;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                state[row][col] =
                        grid[row][col] + Math.min(state[row-1][col], state[row][col-1]);
            }
        }
        return state[n-1][n-1];
    }

    //状态转移方程(递归 + 记忆),从右下角倒推到左上角
    //时间复杂度O(n²), 空间复杂度O(n²)
    private int[][] mem = new int[4][4]; //避免重复计算
    public int minPathSum3(int[][] grid, int i, int j) {
        //到达左上角
        if (i == 0 && j == 0) return grid[0][0];
        //避免重复计算
        if (mem[i][j] > 0) return mem[i][j];

        //当前位置的左边元素
        int minLeft = Integer.MAX_VALUE;
        if (j-1 >= 0) {
            minLeft = minPathSum3(grid, i, j-1);
        }

        //当前位置的上面元素
        int minUp = Integer.MAX_VALUE;
        if (i-1 >= 0) {
            minUp = minPathSum3(grid, i-1, j);
        }

        //当前位置的最小路径
        int currMin = grid[i][j] + Math.min(minLeft, minUp);
        //计算过保存起来, 避免重复计算
        mem[i][j] = currMin;

        return currMin;
    }
}
