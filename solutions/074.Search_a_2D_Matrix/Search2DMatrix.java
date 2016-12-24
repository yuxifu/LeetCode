/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Write an efficient algorithm that searches for a value in an m x n matrix.
   This matrix has the following properties:
   Integers in each row are sorted from left to right.
   The first integer of each row is greater than the last integer of the
   previous row.
   For example,
   Consider the following matrix:
   [
   [1,   3,  5,  7],
   [10, 11, 16, 20],
   [23, 30, 34, 50]
   ]
   Given target = 3, return true.
 */

import java.util.*;

public class Search2DMatrix {

/* binary search */
//time: O(logn)
//space: O(1)
public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end) {
                int mid = (begin + end) / 2;
                int mid_value = matrix[mid/col_num][mid%col_num];

                if( mid_value == target) {
                        return true;

                }else if(mid_value < target) {
                        //Should move a bit further, otherwise dead loop.
                        begin = mid+1;
                }else{
                        end = mid-1;
                }
        }

        return false;
}

// debug
public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        int[][] array = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(s.searchMatrix(array,3));
}

}
