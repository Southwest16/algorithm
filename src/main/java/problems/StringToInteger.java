package problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        String st = str.trim();
        int len = st.length();
        if (st.length() == 0) return 0;

        //boolean isMatch = Pattern.matches("\\+|\\-", String.valueOf(st.charAt(0)));
        Pattern pattern = Pattern.compile("^(\\+|\\-|[0-9])|[0-9]+");
        Matcher matcher = pattern.matcher(st);

        String tmp = "";
        while (matcher.find()) {
            int i = 0;
            if (!tmp.contains("+") || !tmp.contains("-")){
                tmp += matcher.group(i);
                //if (!Pattern.matches("[0-9]", matcher.group(i))) break;
            }
            i++;
        }

        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(tmp);
        if (!m.matches()) return 0;

        if (st.substring(0, tmp.length()).equals(tmp)) {
            if (tmp.length() > 15)
                tmp = tmp.substring(0, 15);
            if (Long.valueOf(tmp) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (Long.valueOf(tmp) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return Integer.valueOf(tmp);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        //System.out.println(myAtoi("3.14159"));
        //System.out.println(myAtoi("words and 987"));
        //System.out.println(myAtoi("4193 with words"));
        //System.out.println(myAtoi("91283472332"));
        System.out.println(myAtoi("   -42"));
        //System.out.println(myAtoi("0-1"));
        //System.out.println(myAtoi("+"));
        //System.out.println(myAtoi("42"));
        //System.out.println(myAtoi("20000000000000000000"));
    }
}
