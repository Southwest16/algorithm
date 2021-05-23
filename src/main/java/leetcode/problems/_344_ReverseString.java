package leetcode.problems;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class _344_ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'u', 'o'};
        reverseString(s);

        for (char c : s) {
            System.out.print(c);
        }
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int len = s.length;
        char tmp;

        for (int i = 0; i < len; i++) {
            //依次交换头尾对应元素
            if (i > len - i - 1) break;
            tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}
