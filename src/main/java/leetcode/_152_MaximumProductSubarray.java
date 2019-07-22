package leetcode;

/**
 * 最大乘积子序列
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class _152_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-9,-6};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];

        int result = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curMaxTmp = curMax * nums[i]; //走到第i个元素时的最大值(也可能是最小值)
            int curMinTmp = curMin * nums[i]; //走到第i个元素时的最小值(也可能是最大值)
            curMax = Math.max(Math.max(curMaxTmp, curMinTmp), nums[i]); //获取第i个元素时的最大值
            curMin = Math.min(Math.min(curMaxTmp, curMinTmp), nums[i]); //获取第i个元素时的最小值

            if(curMax > result) result = curMax; //更新结果
        }
        return result;
    }
}
