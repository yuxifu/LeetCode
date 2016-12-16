/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   Given two numbers represented as strings, return multiplication of the
   numbers as a string.
   Note:
   The numbers can be arbitrarily large and are non-negative.
   Converting the input string to integer is NOT allowed.
   You should NOT use internal library such as BigInteger.

   Solution: Just like what we do when multiplying integers.
 */

import java.util.*;

public class MultiplyStrings {

// Time: O(m * n)
// Space: O(m + n)
public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0) return new String("");
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return new String("0");
        StringBuffer sb = new StringBuffer();
        int[] res = new int[l1+l2];
        for (int i = 0; i < l1; ++i) {
                for (int j = 0; j < l2; ++j) {
                        res[i+j+1] += (num1.charAt(i)-'0') *(num2.charAt(j)-'0');
                }
        }
        int c = 0;
        for (int i = res.length - 1; i>=1; --i) {
                res[i] += c;
                c = res[i] / 10;
                res[i] = res[i] % 10;
                sb.insert(0,res[i]);
        }
        if (c !=0 || res[0] != 0) {
                sb.insert(0,c+res[0]);
        }
        return sb.toString();
}

// debug
public static void main(String[] args) {
        MultiplyStrings s = new MultiplyStrings();
        System.out.println("12345 x 654 = "+ s.multiply("12345","654"));
}
}
