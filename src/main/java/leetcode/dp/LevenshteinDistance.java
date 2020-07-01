package leetcode.dp;

/**
 * 莱文斯坦距离(表示两个字符串差异的大小)
 * 允许增加、删除、替换字符这三个编辑操作
 */
public class LevenshteinDistance {
	private char[] a = "mitcmu".toCharArray();
	private char[] b = "mtacnu".toCharArray();
	private int m = 6;
	private int n = 6;
	private int minDist = Integer.MAX_VALUE;//存储结果


	//动态规划(状态转移表法)
	public int lwstDP(char[] a, char[] b, int m, int n) {
		int[][] minDist = new int[n][m];

		//初始化第0行(a[0]与b[0, 1, ..., m]的编辑距离)
		for (int col = 0; col < m; col++) {
			if (a[0] == b[col])
				minDist[0][col] = col;
			else if (col != 0)
				minDist[0][col] = minDist[0][col - 1] + 1;
			else
				minDist[0][col] = 1;
		}

		//初始化第0列(b[0]与a[0, 1, ..., n]的编辑距离)
		for (int row = 0; row < n; row++) {
			if (a[row] == b[0])
				minDist[row][0] = row;
			else if (row != 0)
				minDist[row][0] = minDist[row - 1][0] + 1;
			else
				minDist[row][0] = 1;
		}

		/**

		 如果：a[i]!=b[j]，那么：min_edist(i, j)就等于：
		 min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)

		 如果：a[i]==b[j]，那么：min_edist(i, j)就等于：
		 min(min_edist(i-1,j)+1, min_edist(i,j-1)+1，min_edist(i-1,j-1))

		 其中，min表示求三数中的最小值。
		 */
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a[i] == b[j])
					minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
				else
					minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
			}

		}

		return minDist[n - 1][m - 1];
	}

	private int min(int x, int y, int z) {
		int minValue = Integer.MAX_VALUE;
		if (x < minValue) minValue = x;
		if (y < minValue) minValue = y;
		if (z < minValue) minValue = z;
		return minValue;
	}

	//回溯算法
	public void lwstBT(int i, int j, int edist) {
		if (i == n || j == m) {
			if (i < n) edist += (n - i);
			if (j < m) edist += (m - j);
			if (edist < minDist) minDist = edist;
			return;
		}

		if (a[i] == b[j]) { //两个字符匹配
			lwstBT(i + 1, j + 1, edist);
		} else { //两个字符不匹配
			lwstBT(i + 1, j, edist + 1); //删除a[i]或者b[j]前添加一个字符
			lwstBT(i, j + 1, edist + 1); //删除b[j]或者a[i]前添加一个字符
			lwstBT(i + 1, j + 1, edist + 1); //将a[i]和b[j]替换为相同字符
		}
	}
}
