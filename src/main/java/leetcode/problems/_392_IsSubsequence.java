package leetcode.problems;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class _392_IsSubsequence {
    public static void main(String[] args) {
        String s = "abcxxx";
        String t = "abc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        //入参判空
        if (s == null || t == null) return false;
        //如果短字符串为空字符""也算包含的情况下
        if (t.length() == 0) return true;

        int lenS = 0;
        int lenT = 0;
        //变量长字符串的每个字符
        while (lenS < s.length()) {
            if (t.charAt(lenT) == s.charAt(lenS)) {
                lenT++;
                lenS++;
                if (lenT == t.length()) return true;
            } else {
                lenT = 0; //如果不同, 短字符串需要从头开始遍历
                lenS++;
                if (lenS == s.length()) return false;
            }
        }

        return false;
    }
}
