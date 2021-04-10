package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字符组合
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_LetterCombinationsOfPhone {
	Map<String, String> phone = new HashMap<String, String>() {{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}};
	List<String> output = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.length() != 0)
			backtrack("", digits);
		return output;
	}

	public void backtrack(String combination, String next_digits) {
		if (next_digits.length() == 0) {
			output.add(combination);
		} else {
			String digit = next_digits.substring(0, 1); // 截取第一个数
			String letters = phone.get(digit); // 对应的字母
			for (int i = 0; i < letters.length(); i++) {
				// 每次截取letters的头部数字
				String letter = letters.substring(i, i + 1);

				// 遍历digits中所有数字, 并进行排列组合
				backtrack(combination + letter, next_digits.substring(1));
			}
		}
	}


}
