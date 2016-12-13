/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-01
 */
/*
   Write a function to find the longest common prefix string amongst an
   array of strings.
 */

import java.util.Scanner;

public class YF_LongestCommonPrefix {

// Time:  O(n * k), k is the length of the common prefix
// Space: O(1)
public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
                return "";
        for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++)
                        if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))
                                return strs[0].substring(0, i);
        }
        return strs[0];
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_LongestCommonPrefix s = new YF_LongestCommonPrefix();
        String[] str1 = new String[] {"a","b","c"};
        System.out.println("a, b, c: "+ s.longestCommonPrefix(str1));
        String[] str2 = new String[] {"abc","abcde","abd"};
        System.out.println("abc, abcde, abd: "+ s.longestCommonPrefix(str2));
}

}
