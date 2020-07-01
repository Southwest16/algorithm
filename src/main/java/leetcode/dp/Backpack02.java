package leetcode.dp;

/**
 * 0-1背包问题升级版
 *
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入到背包中，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少？
 */
public class Backpack02 {
	private static  int[] items = {2,2,4,6,3};  // 物品的重量
	private static  int[] values = {3,4,8,9,6}; // 物品的价值
	private static  int n = 5; // 物品个数
	private static  int maxWeight = 9; // 背包承受的最大重量

	
	public static int knapsack(int[] items, int[] values, int n, int maxWeight) {
		//存储当前状态对应的最大总价值
		int[] states = new int[maxWeight + 1];
		for (int i = 0; i < maxWeight + 1; i++) {
			states[i] = -1;
		}

		states[0] = 0;
		if (items[0] <= maxWeight)
			states[items[0]] = values[0];

		for (int i = 0; i < n; i++) {
			for (int j = maxWeight - items[i]; j >= 0; j--) {
				if (states[j] >= 0) {
					int v = states[j] + values[i];
					if (v > states[j + items[i]])
						states[j + items[i]] = v;
				}
			}
		}

		//找出最大值
		int maxValue = -1;
		for (int i = 0; i <= maxWeight; i++) {
			if (states[i] > maxValue) maxValue = states[i];
		}

		return maxValue;
	}

	public static void main(String[] args) {
		System.out.println(knapsack(items, values, n, maxWeight));
	}
}
