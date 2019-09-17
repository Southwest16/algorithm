package problems;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) return;
        char tmp;

        for (int i = 0; i < len; i++) {
            if (i > len - 1 - i) break;
            tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
    }
    public static void main(String[] args) {
        char[] s = {'h','e','l','u','o'};
        reverseString(s);

        for (char c : s) {
            System.out.print(c);
        }
    }
}
