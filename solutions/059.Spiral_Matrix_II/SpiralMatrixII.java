/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
   For example,
   Given the following matrix:
   [
   [ 1, 2, 3 ],
   [ 4, 5, 6 ],
   [ 7, 8, 9 ]
   ]
   You should return [1,2,3,6,9,8,7,4,5].
 */

import java.util.*;

public class SpiralMatrixII {

// Time: O(n^2)
// Space: O(1)
public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] res = new int[n][n];
        int m = n, row = 0, col = -1, num = 0;
        while (true) {
                for (int i = 0; i < m; ++i) res[row][++col] = ++num;
                if (--n == 0) break;
                for (int i = 0; i < n; ++i) res[++row][col] = ++num;
                if (--m == 0) break;
                for (int i = 0; i < m; ++i) res[row][--col] = ++num;
                if (--n == 0) break;
                for (int i = 0; i < n; ++i) res[--row][col] = ++num;
                if (--m == 0) break;
        }
        return res;
}

// debug
public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
}

}
