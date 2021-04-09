package leetcode.problems;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		String text = "aaab";
		String pattern = "a*";

		System.out.println(isMatch(text, pattern));
		System.out.println("aaab".replaceAll("c*", ""));
	}

	//动态规划
	public static boolean isMatch(String text, String pattern) {
		int n1 = text.length();
		int n2 = pattern.length();

		boolean[][] dp = new boolean[n1 + 1][n2 + 1];
		dp[n1][n2] = true;

		for (int i = n1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				boolean first_match = (i < n1 && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

				if (j + 1 < n2 && pattern.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}


	//递归
	public static boolean isMatch2(String text, String pattern) {
		//对传进的参数判空
		if (pattern.isEmpty()) return text.isEmpty();

		//text文本的第一个字符和pattern的第一个字符是否相等(或者pattern的第一个字符是'.')
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch2(text, pattern.substring(2)) || (first_match && isMatch2(text.substring(1), pattern)));
		} else {
			return first_match && isMatch2(text.substring(1), pattern.substring(1));
		}
	}
}
