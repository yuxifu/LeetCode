/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-20
 */
/*
   Follow up for "Unique Paths":

   Now consider if some obstacles are added to the grids. How many unique
   paths would there be?
   An obstacle and empty space is marked as 1 and 0 respectively in the grid.
   For example,
   There is one obstacle in the middle of a 3x3 grid as illustrated below.
   [
   [0,0,0],
   [0,1,0],
   [0,0,0]
   ]
   The total number of unique paths is 2.

   Solution: Dynamic programming.
 */

import java.util.*;

public class UniquePathsII {

public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < m; i++)
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        for (int j = 1; j < n; j++)
                dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j-1];

        for (int i = 1; i < m; i++)
                for (int j = 1; j < n; j++)
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];

        return dp[m-1][n-1];
}

// Time: o(m * n)
// Space: o(n)
// accepted
public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        //return 0 if the start or the end point is not reachable
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        dp[0] = 1;
        for (int i = 0; i < m; ++i) {
                //set n paths to 0 if not reachable
                dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
                for(int j = 1; j < n; ++j) {
                        //set n paths to 0 if not reachable
                        dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j-1];
                }
        }
        return dp[n-1];
}

public static void main(String[] args) {
        UniquePathsII s = new UniquePathsII();
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(s.uniquePathsWithObstacles_2(obstacleGrid));
}

}
