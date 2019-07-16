package learn;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    public static String reverseWords(String s) {
        //去除字符串首尾的空格, 并以空格(一个或多个)切分字符串
        String[] words = s.trim().split("\\s+");
        int len = words.length;
        //如果数组只有一个元素, 则返回
        if (len <= 1) return s.trim();

        String temp;
        for (int i = 0; i < len; i++) {
            if (i > len - 1 - i) break;
            temp = words[i];
            words[i] = words[len-1-i];
            words[len-1-i] = temp;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords("1"));
    }
}
