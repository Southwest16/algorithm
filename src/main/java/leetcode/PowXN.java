package leetcode;

/**
 * 求 x 的 n 次幂
 * https://leetcode.com/problems/powx-n/
 */
public class PowXN {
    public static void main(String[] args) {
        //System.out.println(PowXN.myPow(1.00000, -2147483648));
        //System.out.println(PowXN.myPow(-1.00000, -2147483648));
        System.out.println(PowXN.myPow(-2.00000, -2147483648));
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(myPow(2, 3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            // n=-2147483648
            if (n == Integer.MIN_VALUE) {
                // -2147483648和2147483647相差1, 所以要再乘以1/x
                return (1/myPow(x, Integer.MAX_VALUE)) * (1/x);
            }
            return 1 / myPow(x, -n);
        }

        // n为偶数, myPow(x * x, n / 2);
        // n为奇数, x * myPow(x * x, n / 2)
        return (n & 1) == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
