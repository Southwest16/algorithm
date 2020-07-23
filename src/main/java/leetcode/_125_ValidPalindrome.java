package leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * 判断是否是回文字符串
 * https://leetcode.com/problems/valid-palindrome/
 */
public class _125_ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("\"OP\""));
	}

	//双指针法
	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left += 1;
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right -= 1;
			if (!String.valueOf(s.charAt(left)).toLowerCase().equals(String.valueOf(s.charAt(right)).toLowerCase()))
				return false;
			left++;
			right--;
		}
		return true;
	}

	//替换非字母数字并反转, 与没反转之前是否相等
	public static boolean isPalindrome2(String s) {
		String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String s2 = new StringBuffer(s1).reverse().toString();
		return s1.equals(s2);
	}
}
