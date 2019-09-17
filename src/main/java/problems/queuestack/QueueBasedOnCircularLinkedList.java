package problems.queuestack;

public class QueueBasedOnCircularLinkedList {
    private String[] items; //数组
    private int n;          //数组大小
    private int head;       //对头下标
    private int tail;       //队尾下标

    //初始化数组
    public QueueBasedOnCircularLinkedList(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        //队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue() {
        //队列为空
        if (tail == head) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }
}
