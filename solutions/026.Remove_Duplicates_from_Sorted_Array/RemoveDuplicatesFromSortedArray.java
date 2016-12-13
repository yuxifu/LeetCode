/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Given a sorted array, remove the duplicates in place such that each
   element appear only once and return the new length.

   Do not allocate extra space for another array, you must do this in place
   with constant memory.

   For example,
   Given input array nums = [1,1,2],

   Your function should return length = 2, with the first two elements of
   nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */

import java.util.*;

public class RemoveDuplicatesFromSortedArray {

// Time: o(n)
// Space: o(1)
public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                        i++;
                        nums[i] = nums[j];
                }
        }
        return i + 1;
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {1,2,2,4,7,7,8,9};
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result Length: " + s.removeDuplicates(array));
        System.out.println("ResultArray: " + Arrays.toString(array));
}
}
