package problems.queuestack;

import java.util.Stack;

/**
 * 使用栈实现队列
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class ImplementQueueUsingStack {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public ImplementQueueUsingStack() {

    }

    //添加一个元素
    public void push(int x) {
        s1.push(x);
    }

    //移除队首元素
    public int pop() {
        peek();
        return s2.pop();
    }

    //获取队首元素, 但不移除
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    //判断队列是否为空
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
