package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class _53_MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[0]; //最大子数组的和
        for (int i = 1; i < nums.length; i++) {
            max1 = Math.max(max1 + nums[i], nums[i]);
            max2 = Math.max(max1, max2);
        }
        return max2;
    }
}
