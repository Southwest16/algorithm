package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 思路
 * 1. 遍历字符串中所有字符
 * 2. 通过Map保存最长子串（key为字符，value为对应下标）
 * 3.
 */
public class _3_LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
		lengthOfLongestSubstring("abcabcbabcd");
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int res = 0;

		// key为字符串s中的字符, value为对应字符的下标
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < n; j++) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				i = Math.max(map.get(c), i);
			}
			res = Math.max(res, j-i+1);
			map.put(c, j+1);
		}
		return res;
	}
}
