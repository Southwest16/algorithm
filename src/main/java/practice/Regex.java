package practice;

public class Regex {
    public static void main(String[] args) {
        String match = "^(13[0-9]|15[0-3,5-9])\\d{8}$";
        boolean bool = "13011112222".matches(match);
        System.out.println(bool);
    }
}
