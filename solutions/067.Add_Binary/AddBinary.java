/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-21
 */
/*
   Given two binary strings, return their sum (also a binary string).
   For example,
   a = "11"
   b = "1"
   Return "100".
 */

import java.util.*;

public class AddBinary {

// Time: o(n)
// Space: o(1)
// accepted
public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
                int sum = carry;
                if (j >= 0) sum += b.charAt(j--) - '0';
                if (i >= 0) sum += a.charAt(i--) - '0';
                sb.append(sum % 2);
                carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
}

// debug
public static void main(String[] args) {
        AddBinary s = new AddBinary();
        System.out.println(s.addBinary("11","1"));
}
}
