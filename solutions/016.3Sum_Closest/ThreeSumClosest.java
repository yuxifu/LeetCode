/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-05
 */
/*
   Given an array S of n integers, find three integers in S such that the
   sum is closest to a given number, target. Return the sum of the three
   integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {

// Time:  O(n^2)
// Space: O(1)
public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
                // first number : nums[i]
                int j = i + 1; // second number
                int k = len - 1; // third number
                while (j < k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (Math.abs(sum - target) < Math.abs(ret - target))
                                ret = sum;
                        if (sum < target) {
                                ++j;
                        } else if (sum > target) {
                                --k;
                        } else {
                                ++j;
                                --k;
                        }
                }
        }
        return ret;

}

// debug
public static void main(String[] args) {
        ThreeSumClosest s = new ThreeSumClosest();
        int[] input = {-1, 2, 1, -4};
        System.out.println("-1, 2, 1, -4: " + s.threeSumClosest(input, 1));
}
}
