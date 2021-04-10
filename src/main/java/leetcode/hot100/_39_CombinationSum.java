package leetcode.hot100;

import java.util.*;

/**
 * 组合总和
 * https://leetcode.com/problems/combination-sum/
 */
public class _39_CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int n = candidates.length;

		Arrays.sort(candidates);
		dfs(candidates, n, target, 0, new ArrayDeque<>(), result);

		return result;
	}

	public static void dfs(int[] candidates, int n, int residue, int begin, Deque<Integer> path, List<List<Integer>> result) {
		if (residue == 0) {
			result.add(new ArrayList<>(path));
			return;
		}

		for (int i = begin; i < n; i++) {
			if (residue - candidates[i] < 0) break;

			path.addLast(candidates[i]);
			dfs(candidates, n, residue - candidates[i], i, path, result);
			path.removeLast();
		}
	}
}
