package problems.queuestack;

import java.util.HashMap;
import java.util.Stack;

/**
 *  判断括号字符串是否有效
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses2("[{[)}]"));
    }

    //方法一
    public static boolean isValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
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
