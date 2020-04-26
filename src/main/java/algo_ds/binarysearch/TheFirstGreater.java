package algo_ds.binarysearch;

/**
 * 查找第一个大于等于给定值的元素
 */
public class TheFirstGreater {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
		int n = a.length;

		System.out.println(bsearch(a, n, 8));
	}

	public static int bsearch(int[] a, int n, int value) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (a[mid] >= value) {
				if (mid == 0 || a[mid - 1] < value)
					return mid;
				else
					right = mid - 1;
			} else if (a[mid] < value) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
