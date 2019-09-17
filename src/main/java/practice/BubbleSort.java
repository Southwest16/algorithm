package practice;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {100, 20, 38, 2, 120, 12};
        int n = a.length;
        bubbleSort(a, n);
        for (int i : a) {
            System.out.println(i);
        }
    }


    public static void bubbleSort(int[] a, int n) {
        if (n == 1) return;

        for (int i = 0; i < n; i++) {
            //flag的作用: 如果数组a本身就是有序的, 那么在第一遍冒泡之后,
            //flag的值还是false, 整个程序就可以退出结束了。
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
