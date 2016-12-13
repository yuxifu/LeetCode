/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-01
 */
/*
   Given an integer, convert it to a roman numeral.
   Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.Scanner;

public class YF_IntegerToRoman {

//illuz
// Time:  O(n)
// Space: O(1)
public String intToRoman(int num) {
        int[] val = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4,
                1
        };
        String[] syb = new String[] {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV",
                "I"
        };

        String roman = "";
        int i = 0;
        while (num > 0) {
                int k = num / val[i];
                while (k-- > 0) {
                        roman += syb[i];
                        num -= val[i];
                }
                i++;
        }
        return roman;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_IntegerToRoman s = new YF_IntegerToRoman();
        System.out.println("1034 (MXXXIV): "+ s.intToRoman(1034));
        System.out.println("999: (CMXCIX)"+ s.intToRoman(999));
}

}
