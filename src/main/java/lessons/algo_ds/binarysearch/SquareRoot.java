package lessons.algo_ds.binarysearch;

public class SquareRoot {
	public static void main(String[] args) {
        System.out.println(square(15, 0.000001));
//		DecimalFormat df = new DecimalFormat("#.000000");
//		System.out.println(df.format(squareRoot(26, 0.0001)));
	}

	//二分查找法
	public static double square(double x, double deltaThreshold) {
		double left = 0.0;
		double right = x;

		while (left <= right) {
			double mid = left + (right - left) / 2; //中间值
			double delta = Math.abs(mid * mid - x); //mid平方与参数x的差值

			if (delta <= deltaThreshold) {
				return mid;
			} else {
				if (mid * mid > x)
					right = mid;
				else
					left = mid;
			}
		}

		return -1.0;
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
