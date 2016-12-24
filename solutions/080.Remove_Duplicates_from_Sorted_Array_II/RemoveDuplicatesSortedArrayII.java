/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Follow up for "Remove Duplicates":
   What if duplicates are allowed at most twice?
   For example,
   Given sorted array nums = [1,1,1,2,2,3],
   Your function should return length = 5, with the first five elements of
   nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */

import java.util.*;

public class RemoveDuplicatesSortedArrayII {

public int removeDuplicates(int[] A) {
    int N = A.length;
    if (N <= 2) return N;
    int idx = 2;
    for (int i = 2; i < N; ++i) {
        if (A[i] != A[idx-2])
            A[idx++] = A[i];
    }
    return idx;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        RemoveDuplicatesSortedArrayII s = new RemoveDuplicatesSortedArrayII();
        int[] array = new int[] {1,1,1,2,2,3};
        System.out.println(s.removeDuplicates(array));
        System.out.println("ResultArray: " + Arrays.toString(array));
}

}
