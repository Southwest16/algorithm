package leecode.queuestack;

public class StackBasedOnLinkedList {
    private Node top = null;

    //入栈
    public void push(int value) {
        Node newNode = new Node(value,null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    //出栈
    public int pop() {
        if (top == null) {  //栈为空
            return -1;
        }
        int value = top.data;   //栈顶元素的值
        top = top.next; //栈顶元素的下一个元素作为栈顶元素
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    //节点类
    private static class Node {
        private int data;   //节点中的数据
        private Node next;  //节点中的指针

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
