package leetcode;

/**
 * 爬楼梯
 * https://leetcode.com/problems/climbing-stairs/
 */
public class _70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if(n == 1) return 1;

        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
