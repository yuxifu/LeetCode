/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Implement next permutation, which rearranges numsbers into the
   lexicographically next greater permutation of numsbers.

   If such arrangement is not possible, it must rearrange it as the
   lowest possible order (ie, sorted in ascending order).

   The replacement must be in-place, do not allocate extra memory.

   Here are some examples. Inputs are in the left-hand column and its
   corresponding outputs are in the right-hand column.
   1,2,3 → 1,3,2
   3,2,1 → 1,2,3
   1,1,5 → 1,5,1
 */

import java.util.*;

public class NextPermutation {

// Time: o(n)
// Space: o(1)
/*Processes: Take A = {1,3,2} as an example:
           1. Traverse from back to forth, find the turning point, that is A[i] = 3.
           2. Sort from the turning point to the end (A[i] to A[end]), so {3,2} becomes {2,3}.
           3. If i equals to 0, finish! Else, goto 4.
           4. Let j = i, search from A[j] to A[end] to find the first elem which is larger than A[i-1], '2' here.
           5. Swap the elem A[j] with A[i-1].
           Finally, the next permutation is {2,1,3}.
 */
public void nextPermutation(int[] nums) {
        int last = nums.length - 1;
        int i = last;
        // Find longest non-increasing suffix
        while (i >0 && nums[i - 1] >= nums [i]) --i;
        // Now i is the head index of the suffix, the turning point


        //i=0, already the greatest. reverse the array to the least and done.
        if (i == 0) {
                for (int l = 0, r = last; l < r; ++l, --r) {
                        int tmp = nums[l];
                        nums[l] = nums[r];
                        nums[r] = tmp;
                }
                return;
        }

        //
        for (int j = last; j >= i; --j) {
                if (nums[j] > nums[i-1]) { //the first nums[j] > nums[i-1]
                        int tmp = nums[j]; //swap
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;

                        //sort to least -> greatest
                        for (int l = i, r = last; l < r; ++l, --r) {
                                int t = nums[l];
                                nums[l] = nums[r];
                                nums[r] = t;
                        }
                        return;
                }
        }
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {1,3,2};
        NextPermutation s = new NextPermutation();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("ResultArray: " + Arrays.toString(array));
}
}
