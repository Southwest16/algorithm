package leetcode;

import java.util.HashMap;

public class _15_ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        int[] result = threeSum(nums, target);
        for (int r: result) {
            System.out.println(r);
        }
    }

    public static int[] threeSum(int[] nums, int target) {
        if(nums == null || nums.length < 3) return new int[0];

        int n = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (hashMap.getOrDefault(target-nums[i]-nums[j], -1) != i &&
                        hashMap.getOrDefault(target-nums[i]-nums[j], -1) != j &&
                        hashMap.containsKey(target-nums[i]-nums[j])) {
                    return new int[]{nums[i], nums[j], target-nums[i]-nums[j]};
                }
            }
        }

        return new int[0];
    }
}
