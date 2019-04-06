package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element
 * https://leetcode.com/problems/majority-element-ii/
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majority = new MajorityElement();

        //int[] nums = {1, 1, 1, 1, 2, 5, 6};
        //int[] nums = {4,4,4,3,5,5,3,5};
        //int[] nums = {4, 2, 1, 1};
        //int[] nums = {3,2,3};
        //int[] nums = {0,0,0};
        int[] nums = {1};

        //Arrays.stream(nums).boxed().collect(Collectors.toList());
        //System.out.println(majority.majorityElement01(nums));
        //System.out.println(majority.majorityElement02(nums));
        System.out.println(majority.majorityElement03(nums));
    }

    /** 出现次数超过30%的元素 */
    public List<Integer> majorityElement03(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int len = nums.length;
        Arrays.sort(nums);

        if (len <= 2) {
            for (int i = 0; i < len && !list.contains(nums[i]); i++) {
                list.add(nums[i]);
            }
            return list;
        }

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == nums[i]) {
                count ++;
                if (count > len * 0.3 && !list.contains(nums[i]))
                    list.add(nums[i]);
                    continue;
            } else {
                count = 1;
            }
        }
        return list;
    }

    /** 数组中出现次数过半的元素 */
    public int majorityElement02(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;

        for (int e : nums) {
            if (hashMap.containsKey(e)){
                hashMap.put(e, hashMap.get(e) + 1);
                if (hashMap.get(e) > nums.length / 2) {
                    result = e;
                    break;
                }
            } else {
               hashMap.put(e, 1);
            }
        }
        return result;
    }

    /** 此种方法的前提条件是，数组不为空，而且一定存在过半的元素 */
    public int majorityElement01(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
