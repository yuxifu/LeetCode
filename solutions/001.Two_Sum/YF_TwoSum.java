/*
 *  Author:      Yuxi Fu
 *  File:        YF_TwoSum.java
 *  Create Date: 2016-11-29
 */

/*
   https://leetcode.com/articles/two-sum/
   Given an array of integers, return indices of the two numbers such that
   they add up to a specific target.
   You may assume that each input would have exactly one solution.
   UPDATE (2016/2/13):
   The return format had been changed to zero-based indices
   Example:
   Given nums = [2, 7, 11, 15], target = 9,
   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 */

import java.util.HashMap;
import java.util.Scanner;

public class YF_TwoSum {

//One-pass Hash Table
/* Complexity Analysis:
   Time complexity : O(n). We traverse the list containing n elements only once.
    Each look up in the table costs only O(1) time.
   Space complexity : O(n). The extra space required depends on the number of items
    stored in the hash table, which stores at most n elements.
 */
public static int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                        return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
}

//brute force
/* Complexity Analysis:
   Time complexity : O(n^2). For each element, we try to find its complement by
    looping through the rest of array which takes O(n) time. Therefore, the time
    complexity is O(n^2).
   Space complexity : O(1).
 */
public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] == target - nums[i]) {
                                return new int[] { i, j };
                        }
                }
        }
        throw new IllegalArgumentException("No two sum solution");
}

//test
public static void main(String[] args) {
        System.out.println("Input Data: numberOfIntergers Intergers Target");
        System.out.println("Example: 4 2 7 11 15 18");
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println("number Of Intergers: " + n);
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; ++i) {
                numbers[i] = cin.nextInt();
        }
        int target = cin.nextInt();

        //One-pass Hash Table
        System.out.println("One-pass Hash Table:");
        int[] res = twoSumHashTable(numbers, target);
        if(res[0]!=0 || res[1]!=0) {
                System.out.println("Result: " + res[0] + " " + res[1]);
        }
        else {
                System.out.println("Result: not found");
        }

        //Brute Force
        System.out.println("Brute Force:");
        res = twoSumBruteForce(numbers, target);
        if(res[0]!=0 || res[1]!=0) {
                System.out.println("Result: " + res[0] + " " + res[1]);
        }
        else {
                System.out.println("Result: not found");
        }

        //
}
}
