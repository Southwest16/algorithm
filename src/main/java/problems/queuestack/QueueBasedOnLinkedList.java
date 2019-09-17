package problems.queuestack;

public class QueueBasedOnLinkedList {
    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(int value) {
        Node newNode = new Node(value, null);
        if (head == tail) {
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = null;
        }
    }

    //出队
    public int dequeue() {
        if (head == null) {
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    //节点类
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
