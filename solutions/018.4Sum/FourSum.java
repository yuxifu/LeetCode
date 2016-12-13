/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-08
 */
/*
Given an array S of n integers, are there elements a, b, c, and d in
S such that a + b + c + d = target? Find all unique quadruplets in the
array which gives the sum of target.
Note: The solution set must not contain duplicate quadruplets.
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]
 */

import java.util.*;

// Time:  O(n^2)
// Space: O(1)
//先求出每两个数的和，放到 `HashSet` 里，再利用之前的 2Sum 去求。
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer[]>> hm = new HashMap<Integer, List<Integer[]>>();
        int len = nums.length;

        Arrays.sort(nums);
        // store pair
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int sum = nums[i] + nums[j];
                Integer[] tuple = {nums[i], i, nums[j], j};
                if (!hm.containsKey(sum)) {
                    hm.put(sum, new ArrayList<Integer[]>());
                }
                hm.get(sum).add(tuple);
            }
        }

        Integer[] keys = hm.keySet().toArray(new Integer[hm.size()]);
        for (int key : keys) {
            if (hm.containsKey(key)) {
                if (hm.containsKey(target - key)) {
                    List<Integer[]> first_pairs = hm.get(key);
                    List<Integer[]> second_pairs = hm.get(target - key);

                    for (int i = 0; i < first_pairs.size(); ++i) {
                        Integer[] first = first_pairs.get(i);
                        for (int j = 0; j < second_pairs.size(); ++j) {
                            Integer[] second = second_pairs.get(j);
                            // check
                            if (first[1] != second[1] && first[1] != second[3] &&
                                    first[3] != second[1] && first[3] != second[3]) {
                                List<Integer> ans = Arrays.asList(first[0], first[2], second[0], second[2]);
                                Collections.sort(ans);
                                if (!ret.contains(ans)) {
                                    ret.add(ans);
                                }
                            }
                        }
                    }

                    hm.remove(key);
                    hm.remove(target - key);
                }
            }
        }

        return ret;
    }

    // Time:  O(n^3)
    // Space: O(1)
    public List<List<Integer>> fourSum2(int[] num, int target) {
        int N = num.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (N < 4) return res;
        Arrays.sort(num);
        for (int i = 0; i < N; ++i)
        {
            if (i > 0 && num[i] == num[i-1]) continue; // avoid duplicates
            for (int j = i+1; j < N; ++j)
            {
                if (j > i+1 && num[j] == num[j-1]) continue; // avoid duplicates
                int twosum = target - num[i] - num[j];
                int l = j + 1, r = N - 1;
                while (l < r)
                {
                    int sum = num[l] + num[r];
                    if (sum == twosum) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]); tmp.add(num[j]); tmp.add(num[l]); tmp.add(num[r]);
                    res.add(tmp);
                        while (l < r && num[l+1] == num[l]) l++; // avoid duplicates
                        while (l < r && num[r-1] == num[r]) r--; // avoid duplicates
                        l++; r--;
                    }
                    else if (sum < twosum) l++;
                    else r--;
                }
            }
        }
        return res;
    }

    // debug
    public static void main(String[] args) {
        FourSum s = new FourSum();
        List<List<Integer> > result = s.fourSum2(new int[] {1, 0, -1, 0, -2, 2}, 0);
        for(List<Integer> four: result) {
                for(Integer item: four) {
                        System.out.print(item + " ");
                }
                System.out.println();
        }
    }
}
