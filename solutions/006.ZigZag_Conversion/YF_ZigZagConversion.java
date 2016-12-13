/*
 *  Author:      Yuxi Fu
 *  File:        YF_ZigZagConversion.java
 *  Create Date: 2016-12-01
 */
/*
   The string "PAYPALISHIRING" is written in a zigzag pattern on a given
   number of rows like this: (you may want to display this pattern in a
   fixed font for better legibility)
   P   A   H   N
   A P L S I I G
   Y   I   R
   And then read line by line: "PAHNAPLSIIGYIR"
   Write the code that will take a string and make this conversion
   given a number of rows:
   string convert(string text, int numRows);
   convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

import java.util.Scanner;

public class YF_ZigZagConversion {

//illuz
/*Complexity Analysis
   Time complexity : O(n).
   Space complexity : O(1).
 */
public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int step = numRows * 2 - 2, len = s.length();
        String ret = "";
        // first row
        for (int i = 0; i < len; i += step)
                ret += s.charAt(i);
        for (int i = 1; i < numRows - 1; i++) {
                for (int j = i; j < len; j += step) {
                        ret += s.charAt(j);
                        if (j + (step - i * 2) < len)
                                ret += s.charAt(j + (step - i * 2));
                }
        }
        // last row
        for (int i = numRows - 1; i < len; i += step)
                ret += s.charAt(i);
        return ret;
}

// debug
public static void main(String[] args) {
        YF_ZigZagConversion s = new YF_ZigZagConversion();
        System.out.println("PAYPALISHIRING: " + s.convert("PAYPALISHIRING",3));
}

}
