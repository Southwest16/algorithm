package geektime_algorithm.heap;

public class Heap {
    private int[] a; //存放堆元素的数组, 从下标1开始存储数据
    private int n; //堆可以存放的最大数据个数
    private int count; //堆中已经存储的数据个数

    public void Heap(int capacity) {
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    //往堆中插入一个元素
    public void insert(int data) {
        if (count >= n) return; //堆已满
        //下标加1, 并把要插入的值赋值给这个下标
        count++;
        a[count] = data;

        int i = count;
        while (a[i] > a[i/2] &&  i/2 > 0) { //i为1时, 已达到根节点, 退出循环;
            //交换元素
            int temp = a[i];
            a[i] = a[i/2];
            a[i/2] = temp;
            //继续下一次的比较
            i = i/2;
        }
    }

    //删除堆顶元素
    public void removeMax() {
        if (count == 0) return; //堆中没有元素
        a[1] = a[count]; //最后一个节点放到堆顶
        --count;
        //堆化
        heapify(a, count, 1);
    }

    //堆化(自上而下对比父子节点)
    public void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;

            //比较当前节点的左子节点和右子节点哪个大, 父节点跟较大的那个交换
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;

            //maxPos == i表明上面两步没执行, 说明已经达到叶子节点了
            if (maxPos == i) break;

            //交换位置
            int tmp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = tmp;

            //继续下一次的交换
            i = maxPos;
        }
    }

    //建堆的时间复杂度为O(n)
    private void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    //堆排序, 时间复杂度是O(nlogn), 原地排序算法, 不稳定
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        //a[k]每次都是堆顶元素(未排序元素中的最大值)
        int k = n;
        while (k > 1) {
            //堆顶元素放到后面
            int tmp = a[1];
            a[1] = a[k];
            a[k] = tmp;
            --k;

            //堆化
            heapify(a, k, 1);
        }
    }
}
