/*
 *  Author:      Yuxi Fu
 *  File:        YF_AddTwoNumbers.java
 *  Create Date: 2016-11-30
 */
/*
   Given a string, find the length of the longest substring without repeating characters.
   Examples:
   Given "abcabcbb", the answer is "abc", which the length is 3.
   Given "bbbbb", the answer is "b", with the length of 1.
 */

import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class YF_LongestSubstringNoRepeat {

//from illuz, AC_record_n.java
public static int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        int prev[] = new int[300];

        // init prev array
        for (int i = 0; i < 300; ++i)
                prev[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
                if (prev[s.charAt(i)] >= left)
                        left = prev[s.charAt(i)] + 1;
                prev[s.charAt(i)] = i;
                if (res < i - left + 1)
                        res = i - left + 1;
        }
        return res;
}

//HashSet with sliding window
//https://leetcode.com/articles/longest-substring-without-repeating-characters/
/* Complexity Analysis:
   Time complexity : O(2n) = O(n). In the worst case is each character
   will be visited twice by i and j.
   Space complexity : O(min(n, m)), where n is size of string, m is size of
   char set.
 */
public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                        set.add(s.charAt(j++));
                        ans = Math.max(ans, j - i);
                }
                else {
                        set.remove(s.charAt(i++));
                }

                System.out.println("i: "+i+"  j: "+j+" ans: "+ans);
        }
        return ans;
}

//HashMap with sliding window
//https://leetcode.com/articles/longest-substring-without-repeating-characters/
/* Complexity Analysis:
   Time complexity : O(n). IIndex j will iterate nn times..
   Space complexity : O(min(n, m)), where n is size of string, m is size of
   char set.
 */
public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                        i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
                System.out.println("i: "+i+"  j: "+j+" ans: "+ans);
        }
        return ans;
}

//brute force
/* Complexity Analysis:
   Time complexity : O(n^3)
   Space complexity : O(min(n, m)), where n is size of string, m is size of
   char set.
 */
public static int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)
                        if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
}

//check if a substring contains no repeating
//substring from start to end-1, [start, end)
public static boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false;
                set.add(ch);
        }
        return true;
}

public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        System.out.println("lengthOfLongestSubstringBruteForce: "+ lengthOfLongestSubstringBruteForce(str));
        System.out.println("lengthOfLongestSubstring: "+ lengthOfLongestSubstring(str));
        System.out.println("lengthOfLongestSubstring2: "+ lengthOfLongestSubstring2(str));
        System.out.println("lengthOfLongestSubstring3: "+ lengthOfLongestSubstring3(str));
}

}
