/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways
can you climb to the top?

Solution: Dynamic Programming. Clime one step from last stair or clime
2 steps from the last last stair.
 */

import java.util.Scanner;

public class ClimbingStairs {

// Time: o(n)
// Space: o(1)
// accepted
public int climbStairs(int n) {
    int[] f = new int[n+1];
    f[0] = 1; f[1] = 1;
    for (int i = 2; i <= n; ++i)
        f[i] = f[i-1] + f[i-2];
    return f[n];
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ClimbingStairs s = new ClimbingStairs();
        System.out.println("100: "+s.climbStairs(10));
}

}
