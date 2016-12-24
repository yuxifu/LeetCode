/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-21
 */
/*
   Given a non-negative number represented as an array of digits, plus
   one to the number.
   The digits are stored such that the most significant digit is at the
   head of the list.
 */

import java.util.*;

public class PlusOne {

public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
                if(digits[i] < 9) {
                        digits[i]++;
                        return digits;
                }

                digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
}


// debug
public static void main(String[] args) {
        PlusOne s = new PlusOne();
        int[] digits = new int[] {9,9,9,9};
        System.out.println(Arrays.toString(digits)+": "+Arrays.toString(s.plusOne(digits)));
}
}
