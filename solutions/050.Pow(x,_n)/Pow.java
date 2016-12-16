/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   Implement pow(x, n).
 */

import java.util.*;

public class Pow {

// Time:
// Space:
// accepted
public double myPow(double x, int n) {
        if (x < 0) return (n % 2 == 0) ? myPow(-x, n) : -myPow(-x, n);
        if (x == 0 || x == 1) return x;
        if (n < 0) {
                if( n == Integer.MIN_VALUE) {
                        n++;     // Make -2147483648 to -2147483647
                        if(x < 0) {
                                x = -x; //we made n odd so need to update sign
                        }
                }
                return 1.0 / myPow(x,-n);
        }
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double half = myPow(x,n/2);
        if (n % 2 == 0) return half * half;
        else return x * half * half;
}
// debug
public static void main(String[] args) {
        Pow s = new Pow();
        System.out.println(s.myPow(5,5));
}
}
