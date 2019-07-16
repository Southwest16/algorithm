package learn.hash;

import java.util.HashMap;

/**
 * 有效的字母异位词
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.validAnagram("art", "tar"));
    }

    public boolean validAnagram(String s1, String s2) {
        //两个HashMap分别存放两个字符串中每个字符的个数,
        //key为每个字符, value为每个字符对应的个数
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();

        //字符串转成字符数组, 遍历计算每个字符的个数并放入HashMap中
        for (char c: s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c: s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        //判断两个HashMap的值是否相等
        return map1.equals(map2);
    }
}
