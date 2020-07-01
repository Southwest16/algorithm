package leetcode_hot100;

/**
 * 最长回文子串
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class _5_LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";

		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String s1 = isPalindrome(s, i, i);
			if (s1.length() > result.length())
				result = s1;

			String s2 = isPalindrome(s, i, i + 1);
			if (s2.length() > result.length())
				result = s2;
		}

		return result;
	}

	private static String isPalindrome(String s, int left, int right) {
		int l = left;
		int r = right;

		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		return s.substring(l + 1, r);
	}
}
