package problems.queuestack;

import java.util.PriorityQueue;

/**
 * 返回数据流中的第K大元素
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    //初始化一个容量为k的优先级队列
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>(k);
        for (int num : nums)
            q.add(num);
    }

    public int add(int val) {
        if (q.size() < k)//队列q中不足k个元素时，添加元素
            q.offer(val);
        else if (q.peek() < val) {//要添加的元素与堆顶元素比较，如果大于堆顶元素，就是替换掉堆顶元素，否则不做任何操作
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}