package problems;

public class MaximumSubarray {
    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-2,1,-3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int max = dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            //i前面所有元素的和
            dp[i-1] = dp[i-1] > 0 ? dp[i-1] : 0;
            //i前面所有元素的和加上下标为i的元素
            dp[i] = nums[i] + dp[i-1];
            //取上一轮循环的最大值和这一轮循环的最大值中的较大者
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
