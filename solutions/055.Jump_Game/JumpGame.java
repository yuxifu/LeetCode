/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
Given an array of non-negative integers, you are initially positioned
at the first index of the array.
Each element in the array represents your maximum jump length at
that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.

Solution: Updated solution: try every reachable index.
          Thank to Wenxin Xing for kindly feedback and pointing out
          my big mistake:)
 */

import java.util.*;

public class JumpGame {

// Time: O(n)
// Space: O(1)
// accepted
public boolean canJump(int[] A) {
    int pos = 0, n = A.length;
    for (int i = 0; i < n; ++i) {
        if (pos >= i) {
            pos = Math.max(pos, i + A[i]);
        }
    }
    return pos >= n - 1;
}

// debug
public static void main(String[] args) {
        JumpGame s = new JumpGame();
        System.out.println("[2,3,1,1,4] : "+ s.canJump(new int[] {2,3,1,1,4}));
}
}
