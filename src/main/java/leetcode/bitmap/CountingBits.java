package leetcode.bitmap;

/**
 * https://leetcode.com/problems/counting-bits/description/
 * 给一个非负整数, 分别输出0到这个数之间所有数的二进制的1的个数
 */
public class CountingBits {
    public static int[] countBits(int num) {
        int[] array = new int[num+1];
        for (int i = 1; i <= num; i++) {
            array[i] += array[i & (i - 1)] + 1;
        }
        return array;
    }
}
