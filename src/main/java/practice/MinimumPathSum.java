package practice;

public class MinimumPathSum {
	public static int sum(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;

		for (int i = 1; i < col; i++)
			grid[0][i] += grid[0][i - 1];

		for (int j = 1; j < row; j++)
			grid[j][0] += grid[j - 1][0];

		for (int m = 1; m < row; m++) {
			for (int n = 1; n< col; n++) {
				grid[m][n] += Math.min(grid[m][n-1], grid[m-1][n]);
			}
		}

		return grid[row-1][col-1];
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}};

		System.out.println(sum(grid));
	}
}
