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


        System.out.println(lps("babad"));
    }


//    public static String lps(String s) {
//        if (s == null || s.length() < 1) return "";
//
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private static int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }


    private static int lps(String s) {
        int n = s.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(L[k][l] + "  ");
            }
            System.out.println();
        }

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
    }


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
