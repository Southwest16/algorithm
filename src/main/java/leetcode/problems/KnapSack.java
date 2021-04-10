package leetcode.problems;

/**
 * 0-1背包
 */
public class KnapSack {
	public int knapsack(int[] weight, int n, int maxWeight) {
		boolean[][] states = new boolean[n][maxWeight + 1];
		states[0][0] = true;

		if (weight[0] < maxWeight) {
			states[0][weight[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < maxWeight; j++) {
				if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
			}

			for (int j = 0; j < maxWeight - weight[i]; j++) {
				if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
			}
		}
		return 0;
	}
}
