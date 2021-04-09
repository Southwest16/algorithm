package leetcode.problems;

import java.text.DecimalFormat;

/**
 * 求x的平方根
 * https://leetcode.com/problems/sqrtx/
 */
public class _69_SquareRoot {
	public static void main(String[] args) {
//        System.out.println(mySqrt(15));
//		DecimalFormat df = new DecimalFormat("#.000000");
//		System.out.println(df.format(squareRoot(26, 0.0001)));
//		System.out.println(df.format(mySqrt(26)));

		System.out.println(square(15, 0.1));
	}


	//牛顿迭代法
	public static double square(int x, double deltaThreshold) {
		int result = x;
		while (result * result > x)
			result = (result + x / result) / 2;

		return result;
	}


	//二分查找法(返回double类型)
	public static double squareRoot(int n, double deltaThreshold) {
		double start = 0.0;
		double end = n;

		while (start <= end) {
			double mid = start + (end - start) / 2; //中间值
			double delta = Math.abs(mid * mid - n); //中间值平方与n的差的绝对值
			if (delta <= deltaThreshold) {
				return mid;
			} else {
				if (mid * mid < n) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		return -1.0;
	}

	//二分查找法(返回int类型)
	public static int mySqrt(int x) {
		if (x == 0) return 0;

		int left = 1; //左界
		int right = x; //右界

		while (true) {
			int mid = left + (right - left) / 2; //中位数
			if (mid * mid > x) {
				right = mid - 1; // 到左半边查找
			} else { // mid * mid <= x
				if ((mid + 1) * (mid + 1) > x) { //找到了
					return mid;
				}
				left = mid + 1; //到右半边查找
			}
		}
	}

	//位运算法
	public static int mySqrt2(int x) {
		if (x == 0) return 0;

		int h = 0;
		// x << n 等于 x * 2ⁿ
		while ((long) (1 << h) * (long) (1 << h) <= x)
			h++;
		h--;

		int b = h - 1;
		int result = (1 << h);
		while (b >= 0) {
			if ((long) (result | (1 << b)) * (long) (result | (1 << b)) <= x)
				result |= (1 << b);
			b--;
		}
		return result;
	}
}
