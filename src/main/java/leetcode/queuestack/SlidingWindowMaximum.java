package leetcode.queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len-k+1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() <= i-k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.pollLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k-1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -3, 5, 3, 6};
        maxSlidingWindow(nums, 3);
    }
}
