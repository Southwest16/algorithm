package learn.sort;

/**
 * 二分查找
 */
public class BinarySearch {
    // 二分查找非递归实现
    private static int bsearch(int[] a, int n, int value) {
        int low = 0; //数组头下标
        int high = n-1; //数组尾下标

        while (low <= high) { //此处一定是<=, 而不是<
            int mid = low + (high - low) >> 1; //中间位置元素的索引, 如果直接(high + low) / 2可能会溢出, 位移运算效率高
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // 二分查找递归实现
    public static int bsearchRec(int[] a, int n, int value) {
        return bsearchInternally(a, 0, n-1, value);
    }
    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + (high - low) >> 1;

        if (a[mid] > value) {
            return bsearchInternally(a, low, mid - 1, value);
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 20, 30, 40, 50};
        int n = a.length;

        System.out.println(bsearch(a, n, 20));
        //System.out.println(bsearchRec(a, n, 120));
    }
}
