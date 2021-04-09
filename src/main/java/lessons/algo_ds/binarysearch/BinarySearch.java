package lessons.algo_ds.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		System.out.println(search(a, 5));

		int left = 0;
		int right = a.length - 1;
		System.out.println(searchRecursion(a, 5, left, right));
	}

	//递归方法
	public static int searchRecursion(int[] a, int n, int left, int right) {
		if (left > right) return -1;

		int mid = left + (right - left) / 2;

		if (a[mid] == n) {
			return mid;
		} else if (a[mid] > n) {
			return searchRecursion(a, n, left, mid - 1);
		} else {
			return searchRecursion(a, n, mid + 1, right);
		}
	}

	//非递归方法
	public static int search(int[] a, int n) {
		if (a == null) return -1;

		int left = 0;
		int right = a.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;  //中间位置元素的索引, 如果直接(high + low) / 2可能会溢出, 位移运算效率高
			if (a[mid] == n) {
				return mid;
			} else if (a[mid] < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}
}
