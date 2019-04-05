package leecode.bitmap;

/**
 * https://leetcode.com/problems/power-of-two/
 * 判断一个数是否是2的幂数
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
