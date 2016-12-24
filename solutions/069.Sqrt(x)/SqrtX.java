/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Implement int sqrt(int x).
   Compute and return the square root of x.
 */

import java.util.Scanner;

public class SqrtX {

// Time: o(logn)
// Space: o(1)
// accepted
public int sqrt(int x) {
        if (x == 0)
                return 0;
        double lasty = 0;
        double y = 1;
        while (y != lasty) {
                lasty = y;
                y = (y + x / y) / 2;
        }
        return (int)y;
}

// Time: o(logn)
// Space: o(1)
// accepted
public int sqrt2(int x) {
    if (x == 0)
        return 0;
    int l = 1, r = x / 2 + 1;
    while (l <= r) {
        int m = (l + r) / 2;
        if (m <= x / m && x / (m + 1) < m + 1)
            return m;
        if (x / m < m)
            r = m - 1;
        else
            l = m + 1;
    }
    return 0;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        SqrtX s = new SqrtX();
        System.out.println("9: "+s.sqrt(9));
        System.out.println("102: "+s.sqrt(102));
}

}
