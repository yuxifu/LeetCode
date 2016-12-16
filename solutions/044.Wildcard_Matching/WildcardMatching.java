/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   Implement wildcard pattern matching with support for '?' and '*'.
   '?' Matches any single character.
   '*' Matches any sequence of characters (including the empty sequence).
   The matching should cover the entire input string (not partial).
   The function prototype should be:
   bool isMatch(const char *s, const char *p)
   Some examples:
   isMatch("aa","a") → false
   isMatch("aa","aa") → true
   isMatch("aaa","aa") → false
   isMatch("aa", "*") → true
   isMatch("aa", "a*") → true
   isMatch("ab", "?*") → true
   isMatch("aab", "c*a*b") → false
 */

import java.util.*;

public class WildcardMatching {

// Time:
// Space:
// accepted
public boolean isMatch(String s, String p) {
        int ii = -1, jj = -1, i = 0, j = 0;
        while (i < s.length()) {
                if (j < p.length() && p.charAt(j) == '*') {
                        while (j < p.length() && p.charAt(j) == '*') ++j;
                        if (j == p.length()) return true;
                        ii = i;
                        jj = j;
                }
                if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                        ++i; ++j;
                } else {
                        if (ii == -1) return false;
                        ++ii;
                        i = ii;
                        j = jj;
                }
        }
        while (j < p.length() && p.charAt(j) == '*') ++j;
        return i == s.length() && j == p.length();
}

// debug
public static void main(String[] args) {
        WildcardMatching s = new WildcardMatching();
        System.out.println("aab, c*a*b : "+ s.isMatch("aab", "c*a*b"));
}
}
