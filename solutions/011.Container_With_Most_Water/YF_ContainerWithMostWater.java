/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-01
 */
/*
   Given n non-negative integers a1, a2, ..., an, where each represents
   a point at coordinate (i, ai). n vertical lines are drawn such that the
   two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
   together with x-axis forms a container, such that the container contains
   the most water.
 */

import java.util.Scanner;

public class YF_ContainerWithMostWater {

//https://leetcode.com/articles/container-most-water/
/* Complexity Analysis
   Time complexity : O(n^2). Calculating area for all n(n-1)/2 height pairs.
   Space complexity : O(1). Constant extra space is used.
 */
public int maxAreaBruteForce(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
                for (int j = i + 1; j < height.length; j++)
                        maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
}

//https://leetcode.com/articles/container-most-water/
//Two Pointer Approach
/* Complexity Analysis
   Time complexity : O(n). Single pass.
   Space complexity : O(1). Constant extra space is used.
 */
public int maxArea(int[] height) {
    int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
        maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
        if (height[l] < height[r])
            l++;
        else
            r--;
    }
    return maxarea;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        YF_ContainerWithMostWater s = new YF_ContainerWithMostWater();
        System.out.println("Brute Force, 1 8 6 2 5 4 8 3 7: "
            + s.maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("1 8 6 2 5 4 8 3 7: "
            + s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
}

}
