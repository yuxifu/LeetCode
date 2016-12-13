/*
 *  Author:      Yuxi Fu
 *  File:        YF_StringToInteger.java
 *  Create Date: 2016-12-01
 */
/*
   Determine whether an integer is a palindrome. Do this without extra space.
 */

import java.util.Scanner;

public class YF_PalindromeNumber {

// Time:  O(logx) = O(1)
// Space: O(1)
public boolean isPalindrome(int x) {
        if(x<0) {
                return false;
        }
        long xx = x;
        long new_xx = 0;
        while (xx > 0) {
                new_xx = new_xx * 10 + xx % 10;
                xx /= 10;
        }
        return new_xx == x;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_PalindromeNumber s = new YF_PalindromeNumber();
        System.out.println("12321: "+s.isPalindrome(12321));
        System.out.println("1232: "+s.isPalindrome(1232));
        System.out.println("-121: "+s.isPalindrome(-121));
}

}
