package leetcode;

/**
 * 求x的平方根
 * https://leetcode.com/problems/sqrtx/
 */
public class _69_Sqrt_x {
    public static void main(String[] args) {
        System.out.println(mySqrt(16));
        System.out.println(1 << 4);
    }

    //位运算
    public static int mySqrt(int x) {
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

    public static int mySqrt2(int x) {
        if (x == 0) return 0;

        int left = 1; //左界
        int right = x; //右界

        while (true) {
            int mid = left + (right - left) / 2; //中位数
            if (mid > x / mid) {
                right = mid - 1; // 到左半边查找
            } else { // mid * mid <= x
                if ((mid + 1) > x / (mid + 1)) { //找到了
                    return mid;
                }
                left = mid + 1; //到右半边查找
            }
        }
    }
}
