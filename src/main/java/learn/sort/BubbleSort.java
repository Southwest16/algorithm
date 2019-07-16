package learn.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {//循环n次
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {//每次冒泡需要比较的次数(n-1-i表示已经冒泡过的元素就不需要再比较了)
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];//交换位置
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) break; //如果数组最初就是完全有序的，那么第一次冒泡之后如果没有交换位置就可以直接退出了
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
