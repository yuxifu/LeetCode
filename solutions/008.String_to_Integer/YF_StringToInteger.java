/*
 *  Author:      Yuxi Fu
 *  File:        YF_StringToInteger.java
 *  Create Date: 2016-12-01
 */
/*
   Implement atoi to convert a string to an integer.
   Hint: Carefully consider all possible input cases. If you want a challenge,
   please do not see below and ask yourself what are the possible input cases.
   Notes: It is intended for this problem to be specified vaguely (ie, no
   given input specs). You are responsible to gather all the input requirements
   up front.
 */

import java.util.Scanner;

public class YF_StringToInteger {

/*Complexity Analysis
   Time complexity : O(n).
   Space complexity : O(1).
 */
public int myAtoi(String str) {

        int ret = 0;
        boolean overflow = false;
        int sign = 1;   // default is '+'
        int i = 0;
        int len = str.length();

        while (i < len && (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t'))
                ++i;
        if (i == len)
                return 0;

        // get sign
        if (str.charAt(i) == '-') {
                ++i;
                sign = -1;
        } else if (str.charAt(i) == '+')
                ++i;

        while (i < len) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9')
                        break;
                if ((sign == 1 && ret > (Integer.MAX_VALUE - (str.charAt(i)-'0')) / 10) ||
                    (sign == -1 && -ret < (Integer.MIN_VALUE + (str.charAt(i)-'0')) / 10)) {
                        overflow = true;
                        break;
                }
                ret = ret * 10 + (str.charAt(i) - '0');
                ++i;
        }
        if (overflow)
                ret = (sign == 1) ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
                ret *= sign;
        return ret;
}

// debug
public static void main(String[] args) {
        YF_StringToInteger s = new YF_StringToInteger();
        System.out.println("12345: "+ s.myAtoi("12345"));
        System.out.println("1 2 3 4 5: "+ s.myAtoi("1 2 3 4 5"));
        System.out.println("     -12345: "+ s.myAtoi("-12345"));
        System.out.println("-1 2 3 4 5: "+ s.myAtoi("-1 2 3 4 5"));
        System.out.println("123456789012345: "+ s.myAtoi("123456789012345"));
}
}
