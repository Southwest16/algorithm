package leetcode.problems;

/**
 * 最长公共子串长度(表示两个字符串相似程度的大小)
 * 只允许增加、删除字符这两个编辑操作
 */
public class LongestCommonSubstringLength {
	public int lcs(char[] a, char[] b, int m, int n) {
		int[][] maxLength = new int[n][m];

		//初始化第0行
		for (int col = 0; col < m; col++) {
			if (a[0] == b[col])
				maxLength[0][col] = 1;
			else if (col != 0)
				maxLength[0][col] = maxLength[0][col - 1];
			else
				maxLength[0][col] = 0;
		}

		//初始化第0列
		for (int row = 0; row < n; row++) {
			if (a[row] == b[0])
				maxLength[row][0] = 1;
			else if (row != 0)
				maxLength[row][0] = maxLength[row - 1][0];
			else
				maxLength[row][0] = 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i] == b[j])
					maxLength[i][j] = max(maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1] + 1);
				else
					maxLength[i][j] = max(maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1]);
			}
		}

		return maxLength[n-1][m-1];
	}


	private int max(int x, int y, int z) {
		int maxValue = Integer.MIN_VALUE;
		if (x > maxValue) maxValue = x;
		if (y > maxValue) maxValue = y;
		if (z > maxValue) maxValue = z;
		return maxValue;
	}
}
