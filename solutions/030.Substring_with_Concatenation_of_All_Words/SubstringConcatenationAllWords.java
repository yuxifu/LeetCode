/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   You are given a string, s, and a list of words, words, that are all of
   the same length. Find all starting indices of substring(s) in s that is
   a concatenation of each word in words exactly once and without any
   intervening characters.

   For example, given:
   s: "barfoothefoobarman"
   words: ["foo", "bar"]

   You should return the indices: [0,9].
 */

import java.util.*;

public class SubstringConcatenationAllWords {

// Time: o(nlogn)
// Space: o(1)
public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        int slen = S.length(), llen = L.length;
        if (slen <= 0 || llen <= 0)
                return ret;
        int wlen = L[0].length(); //all Ls are of the same length

        // get the words' map, how many occurrences of each word
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String str : L) {
                if (words.containsKey(str)) {
                        words.put(str, words.get(str) + 1);
                } else {
                        words.put(str, 1);
                }
        }

        for (int i = 0; i < wlen; ++i) {
                int left = i, count = 0;
                HashMap<String, Integer> tmap = new HashMap<String, Integer>();

                for (int j = i; j <= slen - wlen; j += wlen) {
                        String str = S.substring(j, j + wlen);

                        if (words.containsKey(str)) {
                                if (tmap.containsKey(str)) {
                                        tmap.put(str, tmap.get(str) + 1);
                                } else {
                                        tmap.put(str, 1);
                                }

                                if (tmap.get(str) <= words.get(str)) {
                                        count++;
                                } else {
                                        // too many words, push the 'left' forward
                                        while (tmap.get(str) > words.get(str)) {
                                                String tmps = S.substring(left, left + wlen);
                                                tmap.put(tmps, tmap.get(tmps) - 1);
                                                if (tmap.get(tmps) < words.get(tmps)) {
                                                        // if affect the count
                                                        count--;
                                                }
                                                left += wlen;
                                        }
                                }

                                // get the answer
                                if (count == llen) {
                                        ret.add(left);
                                        // it's better to push forward once
                                        String tmps = S.substring(left, left + wlen);
                                        tmap.put(tmps, tmap.get(tmps) - 1);
                                        count--;
                                        left += wlen;
                                }
                        } else {
                                // not any match word
                                tmap.clear();
                                count = 0;
                                left = j + wlen;
                        }
                }
        }
        return ret;
}

// debug
public static void main(String[] args) {
        SubstringConcatenationAllWords s = new SubstringConcatenationAllWords();
        String[] input = {"foo","bar"};
        System.out.println(s.findSubstring("barfoothefoobarman", input));
}
}
