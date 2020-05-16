package algo_ds.dp;

public class Backpack {
	private int[] weight = {2, 3, 5, 5, 3};  //物品重量
	private int n = 5; // 物品个数
	private int maxWeight = 9; //背包所能承受的最大重量
	private int result = Integer.MIN_VALUE; //结果

	//回溯算法, 避免重复计算
	private boolean[][] mem = new boolean[5][9];

	public void backTrackMemory(int i, int currWeight) {
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
		if (currWeight + weight[i] <= maxWeight) {
			backTrackMemory(i + 1, weight[i] + currWeight);
		}
	}

	public static void main(String[] args) {
		Backpack bp = new Backpack();
		bp.backTrackMemory(0, 0);
		System.out.println(bp.result);
	}
}
