package leetcode.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {// 从1开始：插入排序取数组中第一个元素为已排序区间，其他元素往已排序区间插入
            int value = a[i];//未排序区间的第一个元素
            int j = i - 1;
            for (; j >= 0; j--) {//和已排序区间的元素从尾到头依次比较
                if (a[j] > value) {
                    a[j+1] = a[j]; //大于就向后移动
                } else {
                    break;
                }
            }
            a[j+1] = value; //插入数据
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
