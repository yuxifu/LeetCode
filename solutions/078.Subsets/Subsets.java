/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Given a set of distinct integers, nums, return all possible subsets.
   Note: The solution set must not contain duplicate subsets.
   For example,
   If nums = [1,2,3], a solution is:
   [
   [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
   ]
 */

import java.util.*;

public class Subsets {

public List<List<Integer> > subsets_1(int[] S) {
        Arrays.sort(S);
        List<List<Integer> > res = new ArrayList<List<Integer> >();
        List<Integer> path = new ArrayList<Integer>();
        subsetsRe(S, 0, path, res);
        return res;
}
void subsetsRe(int[] S, int start, List<Integer> path, List<List<Integer> > res) {
        List<Integer> sub = new ArrayList<Integer>(path);
        res.add(sub);
        for (int i = start; i < S.length; ++i) {
                path.add(S[i]);
                subsetsRe(S, i + 1, path, res);
                path.remove(path.size() - 1);
        }
}

//time: O(n * 2^n)
//space: O(1)
public List<List<Integer> > subsets_2(int[] S) {
        Arrays.sort(S);
        List<List<Integer> > res = new ArrayList<List<Integer> >();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; ++i) {
                int sz = res.size();
                System.out.println(sz);
                for (int j = 0; j < sz; ++j) {
                        List<Integer> path = new ArrayList<Integer>(res.get(j));
                        path.add(S[i]);
                        res.add(path);
                }
        }
        return res;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Subsets s = new Subsets();
        int[] nums = new int[] {1,2,3};
        System.out.println(s.subsets_2(nums));
}
}
