package leetcode.queuestack;

public class StackBasedOnArray {
    private String[] items; //数组
    private int count;      //栈中元素个数
    private int n;          //栈的大小

    public StackBasedOnArray(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈操作
    public boolean push(String item) {
        //数组空间不够了，直接返回false，入栈失败
        if (count == n) {
            return false;
        }
        if (count == n) {
            String[] newItems = new String[2*n];
            for (int i = 0; i < n; i++) {
                newItems[i] = items[i];
            }
            newItems[count - 1] = item;
            return true;
        }
        //将item放到下标为count的位置，并且count加一
        items[count] = item;
        ++ count;
        return true;
    }

    //出栈操作
    public String pop() {
        //栈为空，则直接返回null
        if (count == 0) {
            return null;
        }
        //返回下标为count-1的数组元素，并且栈中元素个数count减一
        String tmp = items[count-1];
        --count;
        return tmp;
    }
}
