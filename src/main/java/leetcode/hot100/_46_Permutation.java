package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.com/problems/permutations/
 */
public class _46_Permutation {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		permute(nums);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums) {
		if (tmpList.size() == nums.length) {
			result.add(new ArrayList<>(tmpList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tmpList.contains(nums[i])) continue;
				tmpList.add(nums[i]);
				backtrack(result, tmpList, nums);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
}
