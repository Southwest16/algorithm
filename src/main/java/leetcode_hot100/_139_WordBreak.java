package leetcode_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * https://leetcode.com/problems/word-break/
 */
public class _139_WordBreak {
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");

		wordBreak(s, wordDict);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.size() == 0) return false;

		int len = s.length();

		boolean[] dp = new boolean[len + 1];
		Arrays.fill(dp, false);
		dp[0] = true;

		for (int i = 1; i <= len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j]) {
					String word = s.substring(j, i);
					if (wordDict.contains(word)) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[len];
	}
}
