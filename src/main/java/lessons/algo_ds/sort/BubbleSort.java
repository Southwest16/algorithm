package lessons.algo_ds.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {9, 3, 7, 1, 0};
		bubbleSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}

	public static void bubbleSort(int[] a, int n) {
		if (n <= 1) return;

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true;
				}
			}

			if (!flag) break;
		}
	}
}
