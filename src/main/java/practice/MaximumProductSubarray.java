package practice;

public class MaximumProductSubarray {
	public static int maxProduct(int[] array) {
		if (array == null) return 0;
		if (array.length == 1) return array[0];

		int result = array[0];
		int currMax = array[0];
		int currMin = array[0];

		for (int i = 1; i < array.length; i++) {
			int tmpMax = currMax * array[i];
			int tmpMin = currMin * array[i];

			currMax = Math.max(Math.max(tmpMax, tmpMin), array[i]);
			currMin = Math.min(Math.min(tmpMax, tmpMin), array[i]);

			if (currMax > result) result = currMax;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = {-12, 0, -2, 0, -8};

		System.out.println(maxProduct(array));
	}
}
