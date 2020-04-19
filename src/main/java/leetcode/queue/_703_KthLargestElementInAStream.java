package leetcode.queue;

import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class _703_KthLargestElementInAStream {
	private PriorityQueue<Integer> queue;
	private int k;

	public _703_KthLargestElementInAStream(int k, int[] nums) {
		this.k = k;
		this.queue = new PriorityQueue<>(k); //初始化一个容量为k的小顶堆

		//把数组元素添加到小顶堆中
		for (int num : nums)
			add(num); //调用自定义的add方法
	}

	public int add(int val) {
		if (queue.size() < k) { //如果堆中元素小于k个,就向堆中添加元素
			queue.add(val);
		} else if (val > queue.peek()) { //如果新添加元素大于堆顶元素, 就替换
			queue.poll();
			queue.add(val);
		}
		return queue.peek(); //返回堆顶元素, 也就是第K大元素
	}
}
