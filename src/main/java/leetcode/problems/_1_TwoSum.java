package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 数组元素依次保存到Map中（key为数组元素，value为元素对应下标）
 * 2. 遍历数组，并判断target-nums[i]的差值是否在Map中
 * 3. 如果在Map中，就表明存在两个数的和等于目标值target
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 4;

        int[] result = twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int div = target-nums[i]; //差值
            //Map中包含差值，且不是当前元素
            if (hashMap.containsKey(div) && hashMap.getOrDefault(div, -1) != i) {
                return new int[]{i, hashMap.get(div)};
            }
        }
        return new int[0];
    }
}
