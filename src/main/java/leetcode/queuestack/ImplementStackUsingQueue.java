package leetcode.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementStackUsingQueue {
    private Queue<Integer> q1 = new LinkedList<>();//q1存放栈元素
    private Queue<Integer> q2 = new LinkedList<>();//q2保持为空
    private int top;    //栈顶元素

    public void push(int x) {
        q2.add(x);
        top = x;    //每次向栈中添加元素，都要把被添加元素赋值给变量top，作为栈顶元素
        //将q1中的元素依次添加到q2中(也就是将q1中元素按按入队顺序倒序)
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public void pop() {
        //移除队头元素，并将q1中新的队头元素赋值给top
        q1.remove();
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public int top() {
        return top;
    }
}