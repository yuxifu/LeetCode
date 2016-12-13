/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-09
 */
/*
   Given a string containing just the characters '(', ')', '{', '}',
   '[' and ']', determine if the input string is valid.
   The brackets must close in the correct order, "()" and "()[]{}" are all
   valid but "(]" and "([)]" are not.
 */

import java.util.*;

public class ValidParentheses {

// Time: o(n)
// Space: o(n)
public boolean isValid(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
                int pos = "(){}[]".indexOf(s.substring(i, i + 1));
                if (pos % 2 == 1) {
                        if (stk.isEmpty() || stk.pop() != pos - 1)
                                return false;
                } else {
                        stk.push(pos);
                }
        }
        return stk.isEmpty();
}

// debug
public static void main(String[] args) {
        ValidParentheses s = new ValidParentheses();
        System.out.println("()[]{}: " + s.isValid("()[]{}") );
        System.out.println("([)]: " + s.isValid("([)]") );
        System.out.println("[({}))]: " + s.isValid("[({}))]") );
}
}
