package problems.sort;

/**
 * 归并排序。时间复杂度为O(nlogn), 空间复杂度是O(n)。
 */
public class MergeSort {
	// 递归调用函数
	private static void mergeSortInternally(int[] a, int left, int right) {
		// 递归终止条件
		if (left >= right) return;
		// 取left到right之间的中间位置q,防止（left+right）之和超过int类型最大值
		int q = left + (right - left) / 2;

		//分治递归
		mergeSortInternally(a, left, q);
		mergeSortInternally(a, q + 1, right);

		merge(a, left, right, q);
	}

	//将排好序的数组合并
	public static void merge(int[] a, int left, int right, int q) {
		// 将A[left...q]和A[q+1...right]合并为A[left...right]
		int i = left;
		int j = q + 1;
		int k = 0; // 初始化变量i, j, k
		//申请一个大小跟a[left...right]一样的临时数组
		int[] tmp = new int[right - left + 1];
		while (i <= q && j <= right) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				k++;
				j++;
			}
		}

		//判断哪个子数组中有剩余的数据
		//将剩余的数据拷贝到临时数组tmp
		int start = i;
		int end = q;
		if (j <= right) {
			start = j;
			end = right;
		}
		while (start <= end) {
			tmp[k++] = a[start++];
		}

		// 将tmp中的数组拷贝回a[left...right]
		for (i = 0; i <= right - left; ++i) {
			a[left + i] = tmp[i];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{80, 10, 120, 15, 1, 1};
		int n = a.length;
		mergeSortInternally(a, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}
}
