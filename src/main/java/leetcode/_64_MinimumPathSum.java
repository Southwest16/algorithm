package leetcode;

/**
 * 最小路径和
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class _64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,5,9},
            {2,1,3,4},
            {5,2,6,7},
            {6,8,4,3}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid, grid.length-1, grid[0].length-1));
        /*for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print(mem[i][j] + "  ");
            }
            System.out.println();
        }*/
    }

    //方法一：左上角推到右下角
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int row = grid.length; //行数
        int col = grid[0].length; //列数
        int[][] result = new int[row][col]; //存放每一个位置的最小路径
        int sum = 0;

        //填充第一行
        for (int c = 0; c < col; c++) {
            sum += grid[0][c];
            result[0][c] = sum;
        }

        sum = 0;
        //填充第一列
        for (int r = 0; r < row; r++) {
            sum += grid[r][0];
            result[r][0] = sum;
        }

        //动态规划。填满剩下的所有位置
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                result[i][j] = grid[i][j] + Math.min(result[i-1][j], result[i][j-1]);
            }
        }

        /*for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }*/

        return result[row-1][col-1]; //返回矩阵的右下角元素即为所求结果
    }


    //方法二：右下角推到左上角
    private static int[][] mem = new int[4][4]; //避免重复计算
    public static int minPathSum2(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) return grid[0][0]; //到达左上角

        if (mem[row][col] > 0) return mem[row][col]; //避免重复计算

        //当前位置的左边元素
        int minLeft = Integer.MAX_VALUE;
        if (col >= 1)
            minLeft = minPathSum2(grid, row, col-1);

        //当前位置的上面元素
        int minUp = Integer.MAX_VALUE;
        if (row >= 1)
            minUp = minPathSum2(grid, row-1, col);

        //当前位置的最小路径
        int currMin = grid[row][col] + Math.min(minLeft, minUp);

        //计算过保存起来, 避免重复计算
        mem[row][col] = currMin;

        return currMin;
    }
}
