package leetcode.hot100;

/**
 * 最小路径和
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class _64_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		//第一行每个位置的元素都是其前所有元素的和
		for (int i = 0; i < col; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		//第一列每个位置的元素都是其前所有元素的和
		for (int i = 0; i < row; i++) {
			grid[i][0] += grid[i - 1][0];
		}

		//动态规划矩阵中除第一行和第一列的元素
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		//矩阵grid右下角元素即为最小路径
		return grid[row - 1][col - 1];
	}
}
