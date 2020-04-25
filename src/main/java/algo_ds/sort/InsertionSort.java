package algo_ds.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 1, 3, 2};
		insertionSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}

	public static void insertionSort(int[] a, int n) {
		if (n <= 1) return;

		for (int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (a[j] > value)
					a[j + 1] = a[j];
				else
					break;
			}
			a[j + 1] = value;
		}
	}
}
