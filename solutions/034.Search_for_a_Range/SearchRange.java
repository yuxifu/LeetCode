/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-15
 */
/*
   Given a sorted array of integers, find the starting and ending position
   of a given target value.
   Your algorithm's runtime complexity must be in the order of O(log n).
   If the target is not found in the array, return [-1, -1].
   For example,
   Given [5, 7, 7, 8, 8, 10] and target value 8,
   return [3, 4].
 */


import java.util.*;

public class SearchRange {

// Time: o(logn)
// Space: o(1)
// binary search
public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        int left = 0, right = A.length - 1, mid;

        while (left <= right) {
                if (A[left] == target && A[right] == target) {
                        ret[0] = left;
                        ret[1] = right;
                        break;
                }

                mid = (right + left) / 2;
                if (A[mid] < target) {
                        left = mid + 1;
                } else if (A[mid] > target) {
                        right = mid - 1;
                } else {
                        if (A[right] == target) {
                                ++left;
                        } else {
                                --right;
                        }
                }
        }

        return ret;
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {5, 7, 7, 8, 8, 10};
        SearchRange s = new SearchRange();
        System.out.println(Arrays.toString(s.searchRange(array, 8)));
}
}
