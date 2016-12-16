/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   Given an unsorted integer array, find the first missing positive integer.
   For example,
   Given [1,2,0] return 3,
   and [3,4,-1,1] return 2.
   Your algorithm should run in O(n) time and uses constant space.
 */

import java.util.*;

public class FirstMissingPositive {

// Time:
// Space:
public int firstMissingPositive(int[] A) {
        for(int i=0; i<A.length; i++)
                if(A[i]<=0) A[i]=A.length+2;
        for(int i=0; i<A.length; i++)
        {
                if(Math.abs(A[i])<A.length+1)
                {
                        int cur = Math.abs(A[i])-1;
                        A[cur] = -Math.abs(A[cur]);
                }
        }
        for(int i=0; i<A.length; i++)
                if(A[i]>0) return i+1;
        return A.length+1;
}

// debug
public static void main(String[] args) {
        FirstMissingPositive s = new FirstMissingPositive();
        int[] array = new int[] {3,4,-1,1};
        System.out.println("3,4,-1,1: "+ s.firstMissingPositive(array));
}
}
