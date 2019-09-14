package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class _239_SlidingWindowMaximum {
    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] result = maxSlidingWindow(nums, 3);
//
//        for (int r : result) {
//            System.out.println(r);
//        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(3);
        deque.offer(9);
        deque.offer(5);

        System.out.println(deque.peek());
        System.out.println(deque.peekLast());
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return new int[0];

        int n = nums.length;

        //结果
        int[] result = new int[n - k + 1];
        int index = 0;

        //k长度的窗口。存储的是元素的下标。
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //元素超出窗口左界就被移除
            if (i >= k && window.peek() <= i - k) {
                window.poll(); //移除队头元素
            }

            //判断当前元素nums[i]是否大于窗口中的最大元素;
            //如果有, 就把最大元素之前进来的所有元素移除。
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            //新元素加入窗口
            window.offer(i);

            if (i >= k - 1) {
                result[index] = nums[window.peek()];
                index++;
            }
        }

        return result;
    }
}
