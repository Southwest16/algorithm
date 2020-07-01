package leetcode.dp;

/**
 * 0-1背包
 * 求背包所能装入物品的最大值
 */
public class Backpack01 {
	private static int[] items = {2, 3, 5, 5, 3};  //物品重量
	private static int n = 5; // 物品个数
	private static int maxWeight = 9; //背包所能承受的最大重量
	private static int result = Integer.MIN_VALUE; //结果


	//-------------------------------------------------------------------------------------------
	//动态规划(时间复杂度O(n*maxWeight), 空间复杂度O(n))
	public static int knapsack2(int[] items, int n, int maxWeight) {
		boolean[] states = new boolean[maxWeight + 1];
		states[0] = true;
		if (items[0] <= maxWeight)
			states[items[0]] = true;

		for (int i = 1; i < n; i++) {
			for (int j = maxWeight - items[i]; j >= 0; j--) { //放入第i个物品
				if (states[j] == true) states[j + items[i]] = true;
			}
		}

		for (int i = maxWeight; i >= 0; i--) {
			if (states[i] = true) return i;
		}
		return 0;
	}


	//-------------------------------------------------------------------------------------------
	//动态规划(时间复杂度O(n*maxWeight), 空间复杂度O(n*maxWeight))
	public static int knapsack(int[] items, int n, int maxWeight) {
		boolean[][] states = new boolean[n][maxWeight + 1]; //默认值为false

		//第一行的数据要特殊处理, 可以利用哨兵优化
		states[0][0] = true;
		if (items[0] < maxWeight) {
			states[0][items[0]] = true;
		}

		for (int i = 1; i < n; i++) { //遍历每个物品
			//不放入第i个物品
			for (int j = 0; j <= maxWeight; j++) {
				if (states[i - 1][j] == true) states[i][j] = true;
			}

			//放入第i个物品
			for (int j = 0; j <= maxWeight - items[i]; j++) {
				if (states[i - 1][j] == true) states[i][j + items[i]] = true;
			}
		}

		//最大值为states数组最后一行中, 离最后一个元素最近并且为true的那个
		for (int i = maxWeight; i >= 0; i--) {
			if (states[n - 1][i] = true) return i;
		}

		return 0;
	}


	//-------------------------------------------------------------------------------------------
	//回溯算法(避免重复计算)
	private static boolean[][] mem = new boolean[5][9];
	public static void backTrackMemory(int i, int currWeight) {
		if (i == n || currWeight == maxWeight) {
			if (currWeight > result && currWeight <= maxWeight)
				result = currWeight;
			return;
		}

		//记录是否已计算过
		if (mem[i][currWeight]) return;
		mem[i][currWeight] = true;

		//不装第i个物品
		backTrackMemory(i + 1, currWeight);

		//装入第i个物品(背包当前重量加上第i个物品的重量不大于maxWeight)
		if (currWeight + items[i] <= maxWeight) {
			backTrackMemory(i + 1, items[i] + currWeight);
		}
	}

	public static void main(String[] args) {
		Backpack01 bp = new Backpack01();
		System.out.println(bp.knapsack2(items, n, maxWeight));
//		bp.backTrackMemory(0, 0);
//		System.out.println(bp.result);
	}
}
