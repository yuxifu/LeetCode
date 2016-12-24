/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Given an array of words and a length L, format the text such that each
   line has exactly L characters and is fully (left and right) justified.
   You should pack your words in a greedy approach; that is, pack as many
   words as you can in each line. Pad extra spaces ' ' when necessary so
   that each line has exactly L characters.

   Extra spaces between words should be distributed as evenly as possible.
   If the number of spaces on a line do not divide evenly between words,
   the empty slots on the left will be assigned more spaces than the slots
   on the right.

   For the last line of text, it should be left justified and no extra
   space is inserted between words.

   For example,
   words: ["This", "is", "an", "example", "of", "text", "justification."]
   L: 16.

   Return the formatted lines as:
   [
   "This    is    an",
   "example  of text",
   "justification.  "
   ]
 */

import java.util.*;

public class TextJustification {

private String getOneLine(String[] words, int start, int end, int rest, int L) {
        StringBuilder line = new StringBuilder(words[start]);
        rest += (end - start);
        int even_space = rest + 1, num_of_more = 0;
        if (start != end) {
                even_space = rest / (end - start);
                num_of_more = rest - even_space * (end - start);
        }
        for (int i = start + 1; i <= end; ++i) {
                for (int j = 0; j < even_space; ++j) {
                        line.append(' ');
                }
                if (i - start <= num_of_more)
                        line.append(' ');
                line.append(words[i]);
        }
        while (line.length() < L) {
                line.append(' ');
        }
        return line.toString();
}

public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        int sz = words.length;
        int start_pos = 0;
        int cur_len = 0;

        for (int i = 0; i < sz; ++i) {
                if (cur_len + words[i].length() > L) {
                        ret.add(getOneLine(words, start_pos, i - 1, L - cur_len + 1, L));
                        start_pos = i;
                        cur_len = 0;
                }
                cur_len += words[i].length();
                cur_len += 1;
        }
        ret.add(getOneLine(words, start_pos, sz - 1, 0, L));
        return ret;
}

public List<String> fullJustify_2(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        int i = 0, N = words.length;
        while (i < N) {
                int length = words[i].length();
                int j = i + 1;
                while (j < N && length + words[j].length() + (j-i) <= L) {
                        length += words[j++].length();
                }
                StringBuilder s = new StringBuilder(words[i]);
                boolean isLastLine = (j==N);
                boolean oneWord = (j == i + 1);
                int average = (isLastLine || oneWord) ? 1 : (L-length)/(j-i-1);
                int extra = (isLastLine || oneWord) ? 0 : (L-length)%(j-i-1);
                for (int k = i + 1; k < j; ++k) {
                        char[] tmp = new char[extra>0 ? average+1 : average];
                        Arrays.fill(tmp, ' ');
                        s.append(tmp);
                        s.append(words[k]);
                        extra--;
                }
                char[] tmp = new char[L - s.length()];
                Arrays.fill(tmp, ' ');
                s.append(tmp);
                res.add(s.toString());
                i = j;
        }
        return res;
}

// debug
public static void main(String[] args) {
        TextJustification s = new TextJustification();
        String[] input = new String[] {"This", "is", "an", "example", "of",
                                       "text", "justification."};
        System.out.println(s.fullJustify(input,16));
}
}
