package leecode.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] a, int n) {
        if(n <= 1) return;
        for (int i = 0; i < n - 1; i++) {//取第一个元素为已排序区间，从其余元素中依次获取最小值放入已排序区间的末尾
            int minIndex = i; //先假设未排序区间的第一个元素为最元素
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) { //最小元素与未排序区间元素依次比较
                    minIndex = j; //如果当前元素小于最小元素，就将当前元素的索引作为最小元素索引
                }
            }

            if (minIndex == i) {
                continue;
            }

            //交换数据
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}
