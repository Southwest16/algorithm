package leetcode_hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
		lengthOfLongestSubstring("abcabcbb");
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;

		// key为s中的字符, value为对应字符的下标
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
}
