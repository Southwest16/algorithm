package lessons.algo_ds.binarysearch;

/**
 * 查找第一个值等于给定值的元素
 */
public class TheFirstEqual {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
		int n = a.length;

		System.out.println(bsearch2(a, n, 8));
	}

	public static int bsearch2(int[] a, int n, int value) {
		int left = 0;
		int right = n-1;

		while (left <= right) {
			int mid = left + ((right-left) >> 1);
			if (a[mid] >value) {
				right = mid-1;
			} else if (a[mid] < value) {
				left = mid+1;
			} else {
				if (mid==0 || a[mid-1] != value) //如果是数组的第一个元素, 那么必定是一个要找的值。如果a[mid]的前一个元素不等于要找的值, 那么a[mid]就是要找的第一个值。
					return mid;
				else //如果不是以上两种情况, 那么要找的一个值肯定在mid的左边
					right = mid-1;
			}
		}
		return -1;
	}

	//一种简洁的写法
	public static int bsearch(int[] a, int n, int value) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (a[mid] >= value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (left < n && a[left] == value)
			return left;
		else
			return -1;
	}
}

