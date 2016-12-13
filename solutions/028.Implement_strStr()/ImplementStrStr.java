/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-12
 */
/*
   Implement strStr().

   Returns the index of the first occurrence of needle in haystack, or -1
   if needle is not part of haystack.
 */

import java.util.*;

public class ImplementStrStr {

//brute force
// Time: o(mn), hLen = n, nLen = m
// Space: o(1)
public int strStr1(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if(nLen == 0) return 0;
        if (haystack==null || needle==null || hLen==0) return -1;
        for(int i=0; i<=hLen-nLen; i++) {
                Boolean found = true;
                for(int j=0; j<nLen; j++) {
                        if(needle.charAt(j)!=haystack.charAt(i+j)) {
                                found = false;
                                break;
                        }
                }
                if(found) {
                        return i;
                }
        }
        return (int)-1;
}

//classic KMP
// Time: o(n), sLen = n
// Space: o(1)
public int strStr2(String haystack, String needle) {
        int sLen = haystack.length(), tLen = needle.length();
        if(tLen == 0) return 0;
        if (haystack==null || needle==null || sLen==0) return -1;
        int[] next = new int[tLen+1];
        getNext(needle, next);
        System.out.println("next: "+Arrays.toString(next));
        int i = 0, j = 0;
        while (i < sLen) {
                while (j > -1 && needle.charAt(j) != haystack.charAt(i)) j = next[j];
                ++i; ++j;
                if (j == tLen) return i - j;
        }
        return -1;
}
private void getNext(String T, int[] next){
        int i=0, j=-1;
        next[0]=-1;
        int n = next.length;
        while(i < n - 1) {
                while(j>-1&&T.charAt(j)!=T.charAt(i)) j = next[j];
                ++i; ++j;
                if(i < n - 1 && j < n - 1 && T.charAt(j)==T.charAt(i)) next[i]=next[j];
                else next[i]=j;
        }
}

//Simplified RK (Rabin–Karp) Soluiton
// Time: best/average o(n+m), sLen = n, tLen = m; worse o(nm)
// Space: o(1)
public int strStr3(String haystack, String needle) {
        int sLen = haystack.length(), tLen = needle.length();
        if (tLen == 0) return 0;
        if (haystack==null || needle==null || sLen==0 || sLen < tLen) return -1;
        long fh = 0, fn = 0;
        int head = 0, tail = tLen - 1;
        for (int i = 0; i < tLen; ++i) {
                fh += haystack.charAt(i);
                fn += needle.charAt(i);
        }
        while (tail < sLen) {
                if (fn == fh) {
                        int i = 0;
                        while (i < tLen && needle.charAt(i) == haystack.charAt(i + head)) {
                                ++i;
                        }
                        if (i == tLen) return head;
                }
                if (tail == sLen - 1) return -1;
                fh -= haystack.charAt(head++);
                fh += haystack.charAt(++tail);
        }
        return -1;
}

// debug
public static void main(String[] args) {
        ImplementStrStr s = new ImplementStrStr();
        System.out.println("abcdef, def: " + s.strStr2("abcdef", "ded"));
        System.out.println("abcdef, xy: " + s.strStr2("abcdef", "xy"));
}
}
