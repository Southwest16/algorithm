package math.rec;

import java.util.ArrayList;

/**
 * 在限定总和的情况下，求所有可能的加和方式
 */
public class ChangeCombination {
	public static int[] rewards = {1, 2, 5, 10};

	/**
	 * @param totalReward	总金额
	 * @param result		保存结果
	 */
	public static void rec(int totalReward, ArrayList<Integer> result) {
		//找到了满足条件的结果
		if (totalReward == 10) {
			System.out.println(result);
			return;
		} else if (totalReward > 10) {//不是满足条件的结果
			return;
		} else {
			for (int i = 0; i < rewards.length; i++) {
				ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
				newResult.add(rewards[i]);
				rec(totalReward + rewards[i], newResult);
			}
		}
	}

	public static void main(String[] args) {
		int totalReward = 0;
		rec(totalReward, new ArrayList<>());
	}
}
