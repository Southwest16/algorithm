package leetcode;

/**
 * 最长回文子串
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class _5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //递归
        /*String s = "GEEKSFORGEEKS";
        int n = s.length();
        System.out.println(lps(s.toCharArray(), 0, n - 1));*/

        System.out.println(lps("babbaa"));
    }

    public static String lps(String s) {
        if (s == null || s.length() < 1) return "";

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expandAroundCenter(s, i, i); //字符串中长度为奇数的回文字符串
            if(s1.length() > result.length())
                result = s1;

            String s2 = expandAroundCenter(s, i, i + 1); //字符串中长度为偶数的回文字符串
            if(s2.length() > result.length())
                result = s2;
        }
        return result;
    }

    //判断是否是回文字符串
    private static String expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        //从字符串的中间向两边扩散;
        //如果是奇数回文, 例如"a", 再判断"a"字符串的左右两个字符是否相同, 依次往外扩散;
        //如果是偶数回文, 例如"aa", 再判断左边"a"的左边的字符和右边"a"的右边的字符是否相同, 依次往外扩散;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l+1, r); //截取回文字符串(包括左界, 不包括右界)。
    }


    /*private static int lps(String s) {
        int n = s.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }
        return L[0][n - 1];
    }*/


    /*// 方法一：递归。时间复杂度O(n3), 空间复杂度O(1)
    private static int lps(char[] c, int left, int right) {
        if (left == right) return 1; //只有一个字符

        if (c[left] == c[right] && left + 1 == right) return 2; //只有两个字符, 且相同

        // 第一个字符和最后一个字符匹配
        if (c[left] == c[right]) {
            return lps(c, left + 1, right - 1) + 2;
        }

        // 第一个字符和最后一个字符不匹配
        return Math.max(lps(c, left + 1, right), lps(c, left, right - 1));
    }*/
}
