/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-09
 */
/*
   Given n pairs of parentheses, write a function to generate all
   combinations of well-formed parentheses.
   For example, given n = 3, a solution set is:
   [
   "((()))",
   "(()())",
   "(())()",
   "()(())",
   "()()()"
   ]
 */

import java.util.*;

public class GenerateParentheses {

// Time: o(2^n)
// Space: o(n)
public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>(), inner, outter;
        if (n == 0) {
                ret.add("");
                return ret;
        }
        if (n == 1) {
                ret.add("()");
                return ret;
        }
        for (int i = 0; i < n; ++i) {
                inner = generateParenthesis(i);
                outter = generateParenthesis(n - i - 1);
                for (int j = 0; j < inner.size(); ++j) {
                        for (int k = 0; k < outter.size(); ++k) {
                                ret.add("(" + inner.get(j) + ")" + outter.get(k));
                        }
                }
        }
        return ret;
}

// debug
public static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
}
}
