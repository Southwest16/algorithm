package learn.queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 返回滑动窗口中的最大值
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return new int[0];

        int len = nums.length;
        int[] result = new int[len - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -3, 5, 3, 6};
        int[] result = maxSlidingWindow(nums, 3);

        for (int r: result) {
            System.out.println(r);
        }
    }
}
