package leetcode.problems;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class _191_NumberOf1Bits {
	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1); //从左到右依次打掉二进制位上的1
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(24));
	}
}
