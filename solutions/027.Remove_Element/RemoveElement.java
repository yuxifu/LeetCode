/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Given an array and a value, remove all instances of that value in place
   and return the new length.

   Do not allocate extra space for another array, you must do this in place
   with constant memory.

   The order of elements can be changed. It doesn't matter what you leave
   beyond the new length.

   Example:
   Given input array nums = [3,2,2,3], val = 3

   Your function should return length = 2, with the first two elements of
   nums being 2.
 */

import java.util.*;

public class RemoveElement {

// Time: o(n)
// Space: o(1)
public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                        nums[count] = nums[i];
                        count++;
                }
        }
        return count;
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {1,2,2,4,7,7,8,9};
        RemoveElement s = new RemoveElement();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result Length: " + s.removeElement(array,2));
        System.out.println("ResultArray: " + Arrays.toString(array));
}
}
