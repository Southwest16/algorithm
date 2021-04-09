package leetcode.problems;

import java.util.Stack;

/**
 * 从一个非负整数中移除k个数, 使得剩下的数最小
 * https://leetcode.com/problems/remove-k-digits/
 */
public class _402_RemoveKDigits {
	public static void main(String[] args) {
		System.out.println(removeKDigits("40009", 3));
	}

	public static String removeKDigits(String num, int k) {
		int len = num.length();

		if (k == len) return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		//把所有数字推入栈中, 并移除符合条件的数字
		while (i < num.length()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		//remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
}
