package math.rec;

import java.util.ArrayList;

/**
 * 给定整数n, 找出所有可能的乘积分解(1在解中最多只能出现1次)
 */
public class IntegerProduct {
	public static void rec(int n, ArrayList<Integer> result) {
		if (n == 1) {
			if (!result.contains(1)) {
				result.add(1);
			}
			System.out.println(result);
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				//结果中只能存在一个1
				if ((i == 1) && result.contains(1)) continue;

				ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
				newResult.add(i);

				//能整除才继续执行
				if (n % i != 0) continue;

				rec(n / i, newResult);
			}
		}
	}

	public static void main(String[] args) {
		rec(8, new ArrayList<>());
	}
}
