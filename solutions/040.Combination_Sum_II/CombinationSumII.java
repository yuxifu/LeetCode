/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */


import java.util.*;

public class CombinationSumII {

// Time:
// Space:
public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Arrays.sort(num);
    ArrayList<Integer> path = new ArrayList<Integer>();
    combinationSumRe(num, target, 0, path, res);
    return res;
}
void combinationSumRe(int[] candidates, int target, int start, ArrayList<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
        ArrayList<Integer> p = new ArrayList<Integer>(path);
        res.add(p);
        return;
    }
    for (int i = start; i < candidates.length && target >= candidates[i]; ++i) {
        if (i!=start && candidates[i-1] == candidates[i]) continue;
        path.add(candidates[i]);
        combinationSumRe(candidates, target-candidates[i], i+1, path, res);
        path.remove(path.size() - 1);
    }
}

// debug
public static void main(String[] args) {
        CombinationSumII s = new CombinationSumII();
        int[] array = new int[] {10, 1, 2, 7, 6, 1, 5};
        System.out.println("10, 1, 2, 7, 6, 1, 5: "+ s.combinationSum2(array, 8));
}
}
