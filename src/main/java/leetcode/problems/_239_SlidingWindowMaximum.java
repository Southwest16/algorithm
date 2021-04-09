package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class _239_SlidingWindowMaximum {
	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] result = maxSlidingWindow(nums, 3);

		System.out.println(Arrays.toString(result));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null) return new int[0];

		int n = nums.length;

		//保存结果
		int[] result = new int[n - k + 1];
		int index = 0;

		//window保存的是k个元素的下标。
		Deque<Integer> window = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
		    //1. 被遍历元素是否超出窗口左边界
		    if (i >= k && window.peek() <= i - k)
			window.poll(); //移除队头元素

		    //2. 是否要更新窗口中的最大值
		    //判断当前元素nums[i]是否大于窗口中的最大元素; 如果有, 就把最大元素之前进来的所有元素移除。
		    while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
			window.pollLast();
		    }

		    //新元素加入窗口
		    window.offer(i);

		    //3. 保存窗口最大值
		    //只有窗口中元素大于等于k个时, 才能开始取出窗口中的最大值
		    if (i >= k - 1) {
			result[index] = nums[window.peek()];
			index++;
		    }
		}

		return result;
	}
}
