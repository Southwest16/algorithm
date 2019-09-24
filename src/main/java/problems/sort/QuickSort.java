package problems.sort;

/**
 * 快速排序(数组A[l...r])
 *
 * partition函数的实现：我们通过游标i把A[l...r-1]分成两部分,
 * A[l...i-1]的元素都是小于pivot, 暂且叫它已处理区间, A[i...r-1]是未处理区间。
 * 我们每次都从未处理区间A[i...r-1]中取一个元素A[j], 与pivot对比,
 * 如果小于pivot, 则将其加入到已处理区间的尾部, 也就是A[i]的位置。
 */
public class QuickSort {
    //递归函数
    private static void quickSortInternally(int[] arr, int left, int right) {
        if(left >= right) return;
         int q = partition(arr, left, right);
         quickSortInternally(arr, left, q-1);
         quickSortInternally(arr, q+1, right);
    }

    //分区函数
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    ++i;
                }
            }
        }
        //将轴放到正确的位置
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;
        quickSortInternally(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
