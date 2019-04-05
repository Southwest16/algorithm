package leecode.queuestack;

public class QueueBasedOnArray {
    private String[] items; //数组
    private int n = 0;      //数组大小
    private int head = 0;   //队头下标
    private int tail = 0;   //队尾下标

    //申请一个大小为capacity的数组
    public QueueBasedOnArray(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == n) {//队列末尾没有空间
            if (head == 0) {//整个队列已满
                return false;
            }
            //数据搬迁
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            //数据搬迁之后重新更新对头和队尾
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
