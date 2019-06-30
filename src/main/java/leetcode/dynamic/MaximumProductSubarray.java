package leetcode.dynamic;


import static java.lang.Math.*;

/**
 * 乘积最大子序列
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(m.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums == null) return 0;

        int result = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curMax = curMax * num;
            curMin = curMin * num;

            curMax = max(max(curMax, curMin), num);
            curMin = min(min(curMax, curMin), num);

            if (curMax > result)
                result = curMax;
        }
        return result;
    }
}
