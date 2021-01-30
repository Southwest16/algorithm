package leetcode.hot100;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode.com/problems/group-anagrams/
 */
public class _49_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<>();

		Map<String, List<String>> hashMap = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			// 将相同字符组成的字符串进行排列作为map中的key, 原始字符串作为key对应的value
			Arrays.sort(chars);
			String key = String.valueOf(chars);

			if (!hashMap.containsKey(key))
				hashMap.put(key, new ArrayList<>());

			hashMap.get(key).add(str);
		}

		return new ArrayList<>(hashMap.values());
	}
}
