package leetcode;

/**
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class Fibonacci {
    static int f[] = new int[10000];
    static int sum = 0;

    public static void main(String[] args) {
        //System.out.println(rec(299));
        //System.out.println(dp(50));
        //System.out.println(dp2(10));

        long start = System.currentTimeMillis();
        //System.out.println(fib(9999));
        System.out.println(dp2(9999));
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(end - start);
    }

    //矩阵相乘法
    public static int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return (f[n] = 1);

        // If fib(n) is already computed
        if (f[n] != 0) return f[n];

        int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

        f[n] = (n & 1) == 1
                ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1))
                : (fib(k) * fib(k) + 2 * fib(k) * fib(k - 1));
        return f[n];
    }

    //通项公式法
    public static double formula(int n) {
        double result = 0;
        double sqrt = Math.sqrt(5.0);
        result = (1 / sqrt) *
                (Math.pow((1 + sqrt) / 2, n) - Math.pow((1 - sqrt) / 2, n));
        return result;
    }

    /**
     * 动态规划(Dynamic Programming), 时间复杂度为O(n), 空间复杂度为O(1)
     */
    public static long dp2(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 动态规划(Dynamic Programming), 时间复杂度为O(n), 空间复杂度为O(n)
     */
    public static long dp(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    /**
     * 递归法(recursion), 时间复杂度为2的n次方
     */
    public static int rec(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return rec(n - 1) + rec(n - 2);
        }
    }
}
