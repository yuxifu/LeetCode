/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   The set [1,2,3,…,n] contains a total of n! unique permutations.
   By listing and labeling all of the permutations in order,
   We get the following sequence (ie, for n = 3):
   1. "123"
   2. "132"
   3. "213"
   4. "231"
   5. "312"
   6. "321"
   Given n and k, return the kth permutation sequence.

   Solution: 1. Brute!
          2. combinatorial mathematics.
 */

import java.util.*;

public class PermutationSequence {

public void nextPermutation(char[] num) {
        int last = num.length - 1;
        int i = last;
        while (i > 0 && num[i - 1] >= num [i]) --i;
        for (int l = i, r = last; l < r; ++l, --r) {
                num[l] = (char) (num[l] ^ num[r]);
                num[r] = (char) (num[l] ^ num[r]);
                num[l] = (char) (num[l] ^ num[r]);
        }
        if (i == 0) {
                return;
        }
        int j = i;
        while (j <= last && num[i-1] >= num[j]) ++j;
        num[i-1] = (char) (num[i-1] ^ num[j]);
        num[j] = (char) (num[i-1] ^ num[j]);
        num[i-1] = (char) (num[i-1] ^ num[j]);
}
public String getPermutation_1(int n, int k) {
        char[] num = new char[n];
        for (int i = 0; i < n; ++i) num[i] = (char) (i + '1');
        while (--k != 0) {
                nextPermutation(num);
        }
        return String.valueOf(num);
}

// Time: O(n^2)
// Space: O(1)
// accepted
// Cantor Ordering:
// Construct the k-th permutation with a list of n numbers
// Idea: group all permutations according to their first number (so n groups, each of
// (n - 1)! numbers), find the group where the k-th permutation belongs, remove the common
// first number from the list and append it to the resulting string, and iteratively
// construct the (((k - 1) % (n - 1)!) + 1)-th permutation with the remaining n-1 numbers
public String getPermutation_2(int n, int k) {
        StringBuffer sb = new StringBuffer();
        StringBuffer res = new StringBuffer();
        int total = 1;
        for (int i = 1; i <= n; ++i) {
                total = total * i;
                sb.append(i);
        }
        k--;
        while(n != 0) {
                total = total / n;
                int idx = k / total;
                res.append(sb.charAt(idx));
                k = k % total;
                sb.deleteCharAt(idx);
                n--;
        }
        return res.toString();
}

// debug
public static void main(String[] args) {
        PermutationSequence s = new PermutationSequence();
        System.out.println(s.getPermutation_1(3,4));
}

}
