package leetcode.sort;

/**
 * 快速排序
 */
public class QuickSort {
    //递归函数
    private static void quickSortInternally(int[] arr, int low, int high) {
        if(low >= high) return;
         int q = partition(arr, low, high);
         quickSortInternally(arr, low, q-1);
         quickSortInternally(arr, q+1, high);
    }
    //分区函数
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            //将小于pivot的移到左边
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
        arr[i] = arr[high];
        arr[high] = tmp;

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
