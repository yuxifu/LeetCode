/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Given an array with n objects colored red, white or blue, sort them so
   that objects of the same color are adjacent, with the colors in the
   order red, white and blue.
   Here, we will use the integers 0, 1, and 2 to represent the color
   red, white, and blue respectively.
   Note:
   You are not suppose to use the library's sort function for this problem.
   Follow up:
   A rather straight forward solution is a two-pass algorithm using
   counting sort.
   First, iterate the array counting number of 0's, 1's, and 2's, then
   overwrite array with total number of 0's, then 1's and followed by 2's.
   Could you come up with an one-pass algorithm using only constant space?
 */

import java.util.*;

public class SortColors {

/* one pass */
//time: O(n)
//space: O(1)
public void sortColors(int[] A) {
        int n = A.length;
        if (n <= 1) return;
        for (int i = 0, left = 0, right = n - 1; i <= right; ) {
                if (A[i] == 0) {
                        A[i++] = A[left];
                        A[left++] = 0;
                } else if (A[i] == 2) {
                        A[i] = A[right];
                        A[right--] = 2;
                } else i++;
        }
}

// debug
public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = new int[] {1,1,0,2,0,1,0,0,1,1,1,2,2,1,1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
}

}
