package leetcode.problems;

/**
 * 求x的n次方
 * https://leetcode.com/problems/powx-n/
 */
public class _50_PowXN {
	public static void main(String[] args) {
		//System.out.println(PowXN.myPow(1.00000, -2147483648));
		//System.out.println(PowXN.myPow(-1.00000, -2147483648));
		System.out.println(myPow(-2.00000, -2147483648));
		//System.out.println(Integer.MAX_VALUE);
		System.out.println(myPow(2, 3));
	}

	public static double myPow(double x, int n) {
		if (n == 0) return 1;

		if (n < 0) {
			if (n == Integer.MIN_VALUE) //-2147483648和2147483647相差1, 所以要再乘以1/x
				return 1 / myPow(x, Integer.MAX_VALUE) * 1 / x;
			return 1 / myPow(x, -n);
		}

		return (n & 1) == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
	}

	public static double myPow2(double x, int n) {
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		double pow = 1;
		while (n != 0) {
			if ((n & 1) != 0)
				pow *= x;
			x *= x;
			n >>= 1;
		}

		return pow;
	}
}
