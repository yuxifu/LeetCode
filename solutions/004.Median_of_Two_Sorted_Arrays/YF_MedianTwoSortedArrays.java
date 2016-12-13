/*
 *  Author:      Yuxi Fu
 *  File:        YF_AddTwoNumbers.java
 *  Create Date: 2016-11-30
 */
/*
   There are two sorted arrays nums1 and nums2 of size m and n respectively.
   Find the median of the two sorted arrays. The overall run time complexity
   should be O(log (m+n)).

   Example 1:
   nums1 = [1, 3]
   nums2 = [2]
   The median is 2.0

   Example 2:
   nums1 = [1, 2]
   nums2 = [3, 4]
   The median is (2 + 3)/2 = 2.5
 */

import java.util.Scanner;

public class YF_MedianTwoSortedArrays {

//find Kth in Sorted Arrays
//A[], [astart, aend)
//B[], [bstart, bend)
//k, start with 1, 1 <= k <= m+n
private static double findKthSortedArrays(int A[], int astart, int aend,
                                          int B[], int bstart, int bend, int k) {
        int m = aend - astart, n = bend - bstart;
        if (m < n) {
                return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);
        }
        if (n == 0)
                return A[astart + k - 1];
        if (k == 1)
                return Math.min(A[astart], B[bstart]);

        int pb = Math.min(k / 2, n), pa = k - pb;
        if (A[astart + pa - 1] > B[bstart + pb - 1])
                return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k - pb);
        else if (A[astart + pa - 1] < B[bstart + pb - 1])
                return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k - pa);
        else
                return A[astart + pa - 1];
}

public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((n + m) % 2 == 1)
                return findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1);
        else
                return (findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1) +
                        findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2)) / 2.0;
}

public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int A[] = {1, 2, 4, 7};
        int B[] = {3, 5, 6};
        System.out.println(findMedianSortedArrays(A, B));
}

/*
   public double findMedianSortedArrays(int A[], int B[]) {
    return findMedianHelper(A, B, Math.max(0, (A.length-B.length)/2), Math.min(A.length-1,(A.length+B.length)/2));// don't really understand this line
   }

   public double findMedianHelper(int A[], int B[], int l, int r) {
    int m= A.length;
    int n= B.length;

    if (l > r)
        return findMedianHelper2(B, A, Math.max(0, (n-m)/2), Math.min(n-1, (m+n)/2));
    int i = (l+r)/2;
    int j = (m+n)/2-i;

    assert(i >= 0 && i <= m && j >= 0 && j <= n);
    int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i-1]);
    int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j-1]);
    int Ai = ((i == m) ? Integer.MAX_VALUE : A[i]);
    int Bj = ((j == n) ? Integer.MAX_VALUE : B[j]);

    if (Ai < Bj_1) return findMedianHelper2(A,B,i+1,r);
    if (Ai > Bj) return findMedianHelper2(A,B,l,i-1);

    if (((m+n) % 2) == 1) return A[i];
    return (Math.max(Ai_1, Bj_1) + Ai) / 2.0;
   }
 */

}
