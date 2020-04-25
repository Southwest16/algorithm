package practice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		System.out.println(rec(10));
	}

	public static int rec(int n) {
		if (n == 1) return 1;

		int result = rec(n-1) + 1;
		return result;
	}
}
