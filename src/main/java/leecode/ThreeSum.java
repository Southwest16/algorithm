package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 找出数组中三数之和等于0的元素, a + b + c = 0
 */
public class ThreeSum {
    public static List<List<Integer>> sum(int[] nums) {
        int len = nums.length;

        //将数组放入到HashMap中, key为数组中元素, value为数组中元素对应的下标
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) { //a
            for (int j = i + 1; j < len; j++) { //b
                int third = -(nums[i] + nums[j]);   //c
                //map中包含c, 且key c对应的下标要同时大于i和j
                if (map.containsKey(third) && map.get(third) > i && map.get(third) > j) {

                    list.add(Arrays.asList(nums[i],nums[j],third));

                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = ThreeSum.sum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> l : list ) {
            System.out.println(l);
        }
    }
}