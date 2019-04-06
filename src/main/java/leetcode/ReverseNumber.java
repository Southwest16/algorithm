package leetcode;

public class ReverseNumber {
    public static String reverse(int n) {
        if (n < 0) return "";
        if (n < 10) return Integer.toString(n);

        int last = n - (n/10) * 10;
        return Integer.toString(last) + reverse(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1030));
    }
}
