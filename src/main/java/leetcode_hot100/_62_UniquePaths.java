package leetcode_hot100;

import java.util.Arrays;

/**
 * 不同路径
 * https://leetcode.com/problems/unique-paths/
 */
public class _62_UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(4, 5));
	}

	//动态规划
	public static int uniquePaths(int m, int n) {
		int[] path = new int[n];
		Arrays.fill(path, 1);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[j] += path[j - 1]; //由dp方程优化而来(dp[i][j] = dp[i - 1][j] + dp[i][j - 1])
			}
		}
		return path[n - 1];
	}
}
