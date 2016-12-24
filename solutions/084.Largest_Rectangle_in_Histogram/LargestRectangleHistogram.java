/*
*  Author:      Yuxi Fu
*  File:
*  Create Date: 12/23/2016
*  Descripton:  Using increase-only-stack to deal with it.
*/

import java.util.*;

public class LargestRectangleHistogram {

    //time: o(n)
    //space: o(1)
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stk = new Stack<Integer>();
        int ret = 0;
        for (int i = 0; i <= len; ++i) {
            int h = (i == len ? 0 : height[i]);
            if (stk.isEmpty() || h >= height[stk.peek()]) {
                stk.push(i);
            } else {
                int top = stk.pop();
                ret = Math.max(ret, height[top] * (stk.empty() ? i : i - stk.peek() - 1));
                --i;    // back one step again
            }
        }
        return ret;
    }

    // debug
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LargestRectangleHistogram s = new LargestRectangleHistogram();
        int[] input = {2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(input));
    }
}
