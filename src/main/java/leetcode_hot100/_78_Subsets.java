package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode.com/problems/subsets/
 */
public class _78_Subsets {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		subsets(nums);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, result, new ArrayList<>());
		return result;
	}

	private static void backtrack(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> tmp) {
		result.add(new ArrayList<>(tmp));
		for (int j = i; j < nums.length; j++) {
			tmp.add(nums[j]);
			backtrack(nums, j + 1, result, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
