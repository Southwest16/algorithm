package leetcode;

import java.util.Arrays;
import java.util.Vector;

/**
 * 最长上升子序列
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class _300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        //System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISBinarySearch(nums));

//        int[] array = {2, 3};
//        System.out.println(Arrays.binarySearch(array, 0, array.length, 4));
    }

    //二分查找方法。时间复杂度O(nlogn)。
    public static int lengthOfLISBinarySearch(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int len = 0;
        int[] result = new int[n];
        for (int num: nums) {
            //binarySearch()方法返回, 当被查找key在数组中存在时的索引;
            //如果被查找key不存在, 就返回(-insertionPoint - 1),
            //插入点就是这个key被插入到数组中的那个位置：也就是数组中第一个大于
            //要查找key的索引, 或者也可以说是, 数组中所有小于被查找key的元素的长度。
            int i = Arrays.binarySearch(result, 0, len, num);
            if(i < 0) i = -i - 1;

            result[i] = num;

            if(i == len) len ++;
        }

        return len;
    }


    // DP动态规划方法。时间复杂度为O(n2)
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];
        int result = 1; //最短也有1, 所以初始化为1, 而不是0
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
