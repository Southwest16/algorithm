package lessons.algo_ds.binarysearch;

public class HeapSort {
	private int[] a; //存储堆的数组
	private int n; //数组长度
	private int count; //堆中元素个数

	public HeapSort(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	//堆构建完成之后, 数组中的元素就是按照大顶堆来组织的。
	//数组中第一个元素就是堆中最大元素, 把堆顶元素和最后一个元素交换,
	// 那么最大元素就放到了下标为n的位置.
	public static void sort(int[] a, int n) {
		buildHeap(a, n);

		int k = n;
		while (k > 1) {
			//堆顶元素跟最后一个元素交换
			int tmp = 0;
			tmp = a[k];
			a[k] = a[1];
			a[1] = tmp;

			k--;

			//堆化
			heapify(a, k, 1);
		}
	}

	public static void buildHeap(int[] a, int n) {
		for (int i = n / 2; i >= 1; i--) {
			heapify(a, n, i);
		}
	}

	public static void heapify(int[] a, int n, int i) {
		while (true) {
			int maxPosition = i;

			if (i * 2 < n && a[i] < a[i * 2])
				maxPosition = i * 2;

			if (i * 2 + 1 < n && a[maxPosition] < a[i * 2 + 1])
				maxPosition = i * 2 + 1;

			if (maxPosition == i) break;

			//交换
			int tmp = 0;
			tmp = a[i];
			a[i] = a[maxPosition];
			a[maxPosition] = tmp;

			i = maxPosition;
		}
	}
}
