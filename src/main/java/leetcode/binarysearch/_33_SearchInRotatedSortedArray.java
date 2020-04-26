package leetcode.binarysearch;

/**
 * 在一个循环有序的数组中查找指定值
 */
public class _33_SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 0, 1, 2};
		int n = a.length;

		System.out.println(bsearch(a, n, 1));
	}

	public static int bsearch(int[] a, int n, int value) {
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (a[mid] > a[right])
				left = mid + 1;
			else
				right = mid;
		}

		int rot = left;
		left = 0;
		right = n - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			int realmid = (mid + rot) % n;
			if (a[realmid] == value)
				return realmid;
			else if (a[realmid] > value)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}
