/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Divide two integers without using multiplication, division and mod operator.
   If it is overflow, return MAX_INT.
 */

import java.util.*;

public class DivideTwoIntegers {

// Time: o(nlogn)
// Space: o(1)
public int divide(int dividend, int divisor) {
    boolean flag = dividend < 0 ^ divisor < 0; //^, logical XOR
    long Dividend = Math.abs((long)dividend);
    long Divisor = Math.abs((long)divisor);
    long res = 0;
    while (Dividend >= Divisor) {
        long c = Divisor;
        for (int i = 0; (c << i) <= Dividend; ++i) { //left shift, double
            Dividend -= (c << i);
            res += (1 << i);
        }
    }
    if (flag == true) res = -res;
    if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    return (int)res;
}

// debug
public static void main(String[] args) {
        DivideTwoIntegers s = new DivideTwoIntegers();
        System.out.println("100/7: " + s.divide(100,7));
}
}
