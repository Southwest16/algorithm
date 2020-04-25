package algo_ds.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {9, 3, 7, 1};
		int left = 0;
		int right = a.length - 1;

		sort(a, left, right);
		System.out.println(Arrays.toString(a));
	}

	public static void sort(int[] a, int left, int right) {
		if (left >= right) return; //递归终止条件

		int mid = (left + right) / 2; //中间位置

		sort(a, left, mid); //对数组左半部分不断对半分割
		sort(a, mid + 1, right); //对数组右半部分不断对半分割

		merge(a, left, right, mid); //合并
	}

	public static void merge(int[] a, int left, int right, int mid) {
		int l1 = left; //左半数组的起始位置
		int l2 = mid + 1; //右半数组的起始位置
		int k = 0;

		int[] tmp = new int[right - left + 1];
		while (l1 <= mid && l2 <= right) {
			if (a[l1] <= a[l2]) {
				tmp[k] = a[l1];
				k++;
				l1++;
			} else {
				tmp[k] = a[l2];
				k++;
				l2++;
			}
		}

		int start = l1;
		int end = mid;
		if (l2 <= right) {
			start = l2;
			end = right;
		}

		while (start <= end)
			tmp[k++] = a[start++];

		for (int i = 0; i <= right - left; i++) {
			a[left + i] = tmp[i];
		}
	}
}
