/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Suppose a sorted array is rotated at some pivot unknown to you beforehand.
   (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

   You are given a target value to search. If found in the array return its
   index, otherwise return -1.
   You may assume no duplicate exists in the array.
 */

import java.util.*;

public class SearchInRotatedSortedArray {

// Time: o(logn)
// Space: o(1)
// binary search
public int search(int[] A, int target) {
        int i = 0, j = A.length - 1;
        while (i <= j) {
                int mid = (i + j) / 2;
                if (A[mid] == target)
                        return mid;
                if (A[i] <= A[mid]) {
                        if (A[i] <= target && target < A[mid])
                                j = mid - 1;
                        else
                                i = mid + 1;
                } else {
                        if (A[mid] < target && target <= A[j])
                                i = mid + 1;
                        else
                                j = mid - 1;
                }
        }
        return -1;
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println("4, 5, 6, 7, 0, 1, 2: " +
                           s.search(array, 5));
}


}
