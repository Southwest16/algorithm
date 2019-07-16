package leetcode;

import java.util.HashMap;

public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2};
        int target = 9;

        int[] result = twoSum(nums, target);
        for (int r: result) {
            System.out.println(r);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (hashMap.getOrDefault(target-nums[i], -1) != i &&
                    hashMap.containsKey(target-nums[i])) {
                return new int[]{nums[i], target-nums[i]};
            }
        }
        return new int[0];
    }
}
