/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
Given a set of candidate numbers (C) (without duplicates) and a target
number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
 */


import java.util.*;

public class CombinationSum {

// Time:
// Space:
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Arrays.sort(candidates);
    ArrayList<Integer> path = new ArrayList<Integer>();
    combinationSumRe(candidates, target, 0, path, res);
    return res;
}
void combinationSumRe(int[] candidates, int target, int start,
        ArrayList<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
        ArrayList<Integer> p = new ArrayList<Integer>(path);
        res.add(p);
        return;
    }
    for (int i = start; i < candidates.length && target >= candidates[i]; ++i) {
        path.add(candidates[i]);
        combinationSumRe(candidates, target-candidates[i], i, path, res);
        path.remove(path.size() - 1);
    }
}

// debug
public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        int[] array = new int[] {2, 3, 6, 7};
        System.out.println("2, 3, 6, 7: "+ s.combinationSum(array, 7));
}
}
