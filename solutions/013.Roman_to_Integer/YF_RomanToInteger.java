/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-01
 */
/*
   Given a roman numeral, convert it to an integer.
   Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.Scanner;

public class YF_RomanToInteger {

public int romanToInt(String s) {
        int[] val = new int[255];
        val['I'] = 1; val['V'] = 5; val['X'] = 10; val['L'] = 50;
        val['C'] = 100; val['D'] = 500; val['M'] = 1000;

        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
                if (i > 0 && val[s.charAt(i)] > val[s.charAt(i - 1)]) {
                        ret += val[s.charAt(i)] - 2 * val[s.charAt(i - 1)];
                } else {
                        ret += val[s.charAt(i)];
                }
        }
        return ret;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_RomanToInteger s = new YF_RomanToInteger();
        System.out.println("MXXXIV (1034): "+ s.romanToInt("MXXXIV"));
        System.out.println("CMXCIX (999): "+ s.romanToInt("CMXCIX"));
}
}
