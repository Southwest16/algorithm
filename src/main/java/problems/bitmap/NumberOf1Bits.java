package problems.bitmap;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(23));
        System.out.println(hammingWeight2(24));
    }
}
