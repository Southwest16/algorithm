package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(minPathSum(triangle));
	}

	public static int minPathSum(List<List<Integer>> triangle) {
		if (triangle == null) return 0;

		int row = triangle.size();
		List<Integer> min = triangle.get(row - 1);

		for (int i = row - 2; i >= 1; i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				min.set(j, Math.min(min.get(j), min.get(j + 1)) + triangle.get(i).get(j));
			}
		}

		return min.get(0);
	}
}
