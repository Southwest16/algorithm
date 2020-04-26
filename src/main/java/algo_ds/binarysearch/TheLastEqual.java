package algo_ds.binarysearch;

/**
 * 查找最后一个值等于给定值的元素
 */
public class TheLastEqual {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
		int n = a.length;

		System.out.println(bsearch2(a, n, 8));
	}

	public static int bsearch2(int[] a, int n, int value) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (a[mid] > value) {
				right = mid - 1;
			} else if (a[mid] < value) {
				left = mid + 1;
			} else {
				if (mid == mid - 1 || a[mid + 1] != value)
					return mid;
				else
					left = mid + 1;
			}
		}
		return -1;
	}
}
