package leetcode.problems;

import java.util.HashMap;
import java.util.Stack;

/**
 *  判断括号字符串是否有效
 * https://leetcode.com/problems/valid-parentheses/
 */
public class _20_ValidParentheses {
	public static void main(String[] args) {
		String s = "（";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		//遍历字符串中每个字符
		for (char c : s.toCharArray()) {
			//如果存在左半边括号, 就把对应的右半边括号压入栈
			if ('(' == c) {
				stack.push(')');
			} else if ('[' == c) {
				stack.push(']');
			} else if ('{' == c) {
				stack.push('}');
			} else if(stack.isEmpty() || stack.pop() != c) { //遍历到右半边括号时会进入这个判断分支, 并开始出栈
				return false;
			}
		}

		//如果最后栈中元素全部出栈, 则为合法字符串
		return stack.isEmpty();
	}

	//方法二
	public static boolean isValidParentheses(String s) {
		HashMap<Character, Character> hashMap = new HashMap<>();
		hashMap.put(')', '(');
		hashMap.put(']', '[');
		hashMap.put('}', '{');

		Stack<Character> stack = new Stack<>(); //初始化一个栈
		char[] array = s.toCharArray(); //将字符串转成char数组
		//遍历整个char数组
		for (char c : array) {
			if (hashMap.containsKey(c)) {
				if ((stack.isEmpty() ? '#' : stack.pop()) != hashMap.get(c)) return false;  //三元条件是避免stack.pop()出现EmptyStackException
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
