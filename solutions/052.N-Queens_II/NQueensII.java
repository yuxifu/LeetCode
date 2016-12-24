/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   Follow up for N-Queens problem.
   Now, instead outputting board configurations, return the total number of
   distinct solutions.

   Solution: Recursion (DFS).
 */

import java.util.*;

public class NQueensII {

private int count;

// Time: O(n!)
// Space: O(n)
//https://discuss.leetcode.com/topic/5962/accepted-java-solution/7
int result = 0;
public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] dia45 = new boolean[2 * n - 1];
        boolean[] dia135 = new boolean[2 * n - 1];
        helper(0, n, column, dia45, dia135);
        return result;
}
private void helper(int row, int n, boolean[] column, boolean[] dia45, boolean[] dia135) {
        if (row == n) {
                result++;
                return;
        }
        for (int col = 0; col < n; col++) {
                if (!column[col] && !dia45[col + row] && !dia135[n - 1- row + col]) {
                        column[col] = dia45[col + row] = dia135[n - 1- row + col] = true;
                        helper(row + 1, n, column, dia45, dia135);
                        column[col] = dia45[col + row] = dia135[n - 1- row + col] = false;
                }
        }
}

// debug
public static void main(String[] args) {
        NQueensII s = new NQueensII();
        System.out.println(s.totalNQueens(4));
}
}
