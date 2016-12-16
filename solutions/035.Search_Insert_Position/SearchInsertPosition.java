/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-15
 */
/*
   Given a sorted array and a target value, return the index
   if the target is found. If not, return the index where it
   would be if it were inserted in order.
   You may assume no duplicates in the array.
   Here are few examples.
   [1,3,5,6], 5 → 2
   [1,3,5,6], 2 → 1
   [1,3,5,6], 7 → 4
   [1,3,5,6], 0 → 0
 */


import java.util.*;

public class SearchInsertPosition {

// Time: o(logn)
// Space: o(1)
// binary search
public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
                mid = (l + r) / 2;
                if (nums[mid] < target)
                        l = mid+1;
                else
                        r = mid;
        }
        return nums[l] < target ? l + 1 : l;
}

// debug
public static void main(String[] args) {
        int[] array = new int[] {1,3,5,6};
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(s.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(s.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(s.searchInsert(new int[] {1,3,5,6}, 0));
}
}
