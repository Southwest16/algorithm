package leetcode.hot100;

/**
 * 最大乘积子序列
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class _152_MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		if (nums == null) return 0;
		if (nums.length == 1) return nums[0];

		int result = nums[0];
		int curMax = nums[0];
		int curMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curMaxTmp = curMax * nums[i];
			int curMinTmp = curMin * nums[i];

			// 注意要考虑nums[i]为负数的情况, 这时要取curMaxTmp和curMinTmp的较大者
			curMax = Math.max(nums[i], Math.max(curMaxTmp, curMinTmp));
			curMin = Math.min(nums[i], Math.min(curMaxTmp, curMinTmp));

			// 更新结果
			if (curMax > result) result = curMax;
		}
		return result;
	}
}
