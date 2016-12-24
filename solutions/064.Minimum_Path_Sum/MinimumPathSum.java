/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-21
 */
/*
   Given a m x n grid filled with non-negative numbers, find a path from
   top left to bottom right which minimizes the sum of all numbers along its path.

   Solution: Dynamic programming.
 */

import java.util.*;

public class MinimumPathSum {

// Time: o(m * n), m #rows, n #cols
// Space: o(n)
// accepted
public int minPathSum(int[][] grid) {
        if (grid.length == 0) return Integer.MIN_VALUE;
        int M = grid.length, N = grid[0].length;
        int[] dp = new int[N];
        dp[0] = grid[0][0];
        for (int i = 1; i < N; ++i)
                dp[i] = grid[0][i] + dp[i-1];

        for (int i = 1; i < M; ++i)
        {
                dp[0] += grid[i][0];
                for (int j = 1; j < N; ++j)
                        dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
        }

        return dp[N-1];
}

public static void main(String[] args) {
        MinimumPathSum s = new MinimumPathSum();
        int[][] grid = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(s.minPathSum(grid));
}

}
