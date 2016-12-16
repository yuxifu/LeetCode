/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

Solution: dfs...
 */

import java.util.*;

public class PermutationsII {

    // Time: O(n * n!)
    // Space: O(n)
    // accepted
    public List<List<Integer> > permuteUnique(int[] num) {
            List<List<Integer> > res = new ArrayList<List<Integer> >();
            List<Integer> path = new ArrayList<Integer>();
            Arrays.sort(num);
            boolean[] visited = new boolean[num.length];
            Arrays.fill(visited, false);
            permuteRe(num, res, path,visited);
            return res;
    }
    void permuteRe(int[] num, List<List<Integer> > res, List<Integer> path, boolean[] visited) {
            if(path.size() == num.length) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                    res.add(tmp);
                    return;
            }
            for (int i = 0; i < num.length; ++i) {
                    if(visited[i]||(i!=0&&num[i-1]==num[i]&&visited[i-1])) continue;
                    visited[i] = true;
                    path.add(num[i]);
                    permuteRe(num, res, path, visited);
                    path.remove(path.size() - 1);
                    visited[i] = false;
            }
    }

// debug
public static void main(String[] args) {
        PermutationsII s = new PermutationsII();
        System.out.println("1,1,2 : "+ s.permuteUnique(new int[] {1,1,2}));
}
}
