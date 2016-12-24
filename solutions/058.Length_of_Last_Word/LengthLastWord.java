/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   Given a string s consists of upper/lower-case alphabets and empty space
   characters ' ', return the length of last word in the string.
   If the last word does not exist, return 0.
   Note: A word is defined as a character sequence consists of non-space
   characters only.
   For example,
   Given s = "Hello World",
   return 5.
 */

import java.util.*;

public class LengthLastWord {

// Time: O()
// Space: O()
public int lengthOfLastWord(String s) {
        int res = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') --i;
        while (i >= 0 && s.charAt(i) != ' ') {
                --i; ++res;
        }
        return res;
}

// debug
public static void main(String[] args) {
        LengthLastWord s = new LengthLastWord();
        System.out.println(s.lengthOfLastWord("Hello World"));
}

}
