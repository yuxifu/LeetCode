/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-02
 */
/*
   Given an array S of n integers, are there elements a, b, c in S such that
   a + b + c = 0? Find all unique triplets in the array which gives
   the sum of zero.
   Note: The solution set must not contain duplicate triplets.
   For example, given array S = [-1, 0, 1, 2, -1, -4],
   A solution set is:
   [
   [-1, 0, 1],
   [-1, -1, 2]
   ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

// Time:  O(n^2)
// Space: O(1)
/**
 * param numbers : Give an array numbers of n integer
 * return : Find all unique triplets in the array which gives the sum of zero.
 */
public List<List<Integer> > threeSum(int[] nums) {
        List<List<Integer> > ret = new ArrayList<List<Integer> >();
        int len = nums.length, tar = 0;

        if (len <= 2)
                return ret;

        // Make nums in increasing order. Time: O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i <= len - 3; i++) {
                // first number : num[i]
                int j = i + 1; // second number
                int k = len - 1; // third number
                while (j < k) {
                        if (nums[i] + nums[j] + nums[k] < tar) {
                                ++j;
                        } else if (nums[i] + nums[j] + nums[k] > tar) {
                                --k;
                        } else {
                                ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                                ++j;
                                --k;
                                // folowing 3 while can avoid the duplications
                                while (j < k && nums[j] == nums[j - 1])
                                        ++j;
                                while (j < k && nums[k] == nums[k + 1])
                                        --k;
                        }
                }
                while (i <= len - 3 && nums[i] == nums[i + 1])
                        ++i;
        }
        return ret;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ThreeSum s = new ThreeSum();
        List<List<Integer> > result = s.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        for(List<Integer> triplet: result) {
                for(Integer item: triplet) {
                        System.out.print(item + " ");
                }
                System.out.println();
        }
}

}
