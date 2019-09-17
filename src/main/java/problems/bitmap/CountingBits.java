package problems.bitmap;

/**
 * https://leetcode.com/problems/counting-bits/description/
 * 给一个非负整数, 分别输出0到这个数之间所有数的二进制的1的个数
 */
public class CountingBits {
    public static void main(String[] args) {
        //System.out.println(3 & 2);

        int[] array = countBits(4);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] countBits(int num) {
        int[] array = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            array[i] += array[i & (i - 1)] + 1;
        }
        return array;
    }
}
