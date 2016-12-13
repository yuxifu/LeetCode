/*
 *  Author:      Yuxi Fu
 *  File:        YF_ReverseInteger.java
 *  Create Date: 2016-12-01
 */
/*
   Reverse digits of an integer.
   Example1: x = 123, return 321
   Example2: x = -123, return -321
 */

import java.util.Scanner;

public class YF_ReverseInteger {

/*Complexity Analysis
   Time complexity : O(1).
   Space complexity : O(1).
 */
public int reverse(int x) {
        int ret = 0;
        while (Math.abs(x) != 0) {
                int prev = ret;
                ret = ret * 10 + x % 10;
                if(ret/10 != prev)
                        return 0;
                x /= 10;
        }
        return ret;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_ReverseInteger s = new YF_ReverseInteger();
        System.out.println("123: " + s.reverse(123));
        System.out.println("-123: " + s.reverse(-123));
        System.out.println("1534236469: " + s.reverse(1534236469));
}

}
