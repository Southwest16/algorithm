package learn;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {36, 8, 12, 4, 60};
        System.out.println(twoSum(12, array)[0]);
        //System.out.println(twoSum_0(12, array)[0]);
    }

    //时间复杂度O(n),空间复杂度O(n)
    public static int[] twoSum_0 (int sum, int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int two = sum - array[i];
            if (hashMap.containsKey(two)) {
                return new int[]{array[i], two};
            }
            hashMap.put(array[i], i);
        }
        return new int[]{0};
    }

    //时间复杂度O(n2),空间复杂度O(1)
    public static int[] twoSum (int sum, int[] array) {
        int len = array.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(array[i] + array[j] == sum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[]{};
    }
}
