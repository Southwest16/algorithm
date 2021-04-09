package leetcode.problems;

public class Backpack03 {
	public static void double11Advance(int[] items, int n, int maxWeight) {
		boolean[][] states = new boolean[n][3 * maxWeight + 1];
		states[0][0] = true;
		if (items[0] < 3 * maxWeight)
			states[0][items[0]] = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3 * maxWeight; j++) {
				if (states[i - 1][j] == true) states[i][j] = true;
			}

			for (int j = 0; j < 3 * maxWeight - items[i]; j++) {
				if (states[i - 1][j] == true) states[i][j + items[i]] = true;
			}
		}

		int k;
		for (k = maxWeight; k < 3 * maxWeight + 1; k++) {
			if (states[n - 1][k] == true) break;
		}

		if (k == 3 * maxWeight + 1) return;
		for (int i = n - 1; i >= 1; i--) {
			if (k - items[i] >= 0 && states[i - 1][k - items[i]] == true) {
				System.out.println(items[i] + "");
				k = k - items[i];
			}
		}

		if (k != 0) System.out.println(items[0]);
	}
}
