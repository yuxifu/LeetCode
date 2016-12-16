/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   The count-and-say sequence is the sequence of integers beginning as follows:
   1, 11, 21, 1211, 111221, ...
   1 is read off as "one 1" or 11.
   11 is read off as "two 1s" or 21.
   21 is read off as "one 2, then one 1" or 1211.
   Given an integer n, generate the nth sequence.
   Note: The sequence of integers will be represented as a string.
 */


import java.util.*;

public class CountAndSay {

// Time: o(n * 2^n)
// Space: o(2^n)
public String countAndSay(int n) {
    StringBuffer s = new StringBuffer("1");
    StringBuffer res = new StringBuffer();
    while((--n) != 0){
        res.setLength(0);
        int size = s.length();
        int cnt = 1;
        char cur = s.charAt(0);
        for(int i=1;i<size;i++){
            if(s.charAt(i)!=cur){
                res.append(cnt);
                res.append(cur);
                cur = s.charAt(i);
                cnt = 1;
            }else ++cnt;
        }
        res.append(cnt);
        res.append(cur);
        StringBuffer tmp = s;
        s = res;
        res = tmp;
    }
    return s.toString();
}

// debug
public static void main(String[] args) {
        CountAndSay s = new CountAndSay();
        System.out.println("1: "+ s.countAndSay(1));
        System.out.println("2: "+ s.countAndSay(2));
        System.out.println("3: "+ s.countAndSay(3));
        System.out.println("4: "+ s.countAndSay(4));
        System.out.println("5: "+ s.countAndSay(5));
}
}
