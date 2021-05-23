package leetcode.problems;

/**
 * https://leetcode.com/problems/resulterse-integer/
 */
public class _7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1030));
    }

    /*public static String reverse(int n) {
        if (n < 0) return "";
        if (n < 10) return Integer.toString(n);

        int last = n - (n / 10) * 10;
        return Integer.toString(last) + reverse(n / 10);
    }*/

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int bitNumber = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && bitNumber > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && bitNumber < -8))
                return 0;

            result = result * 10 + bitNumber;
        }
        return result;
    }
}
