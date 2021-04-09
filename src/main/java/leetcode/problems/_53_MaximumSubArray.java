package leetcode.problems;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 求给定数组中最大和的子数组
 */
public class _53_MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[0]; //用来保存下标i之前的最大和
        for (int i = 1; i < nums.length; i++) {
            max1 = Math.max(max1 + nums[i], nums[i]); //下标i处的元素和i之前所有元素的和与i处元素的较大者
            max2 = Math.max(max1, max2);
        }
        return max2;
    }
}
