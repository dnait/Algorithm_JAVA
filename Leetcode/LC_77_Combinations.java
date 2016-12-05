/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/

//use k - 1 to countdown
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) return res;
        dfs(n, 1, new ArrayList<Integer>(), k, res);
        return res;
    }
    private void dfs(int n, int index, List<Integer> tmp, int k, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(tmp));  //need to new ArrayList<>(tmp), or will be null
        }
        for (int i = index; i <= n; i++) {   //also i starts from “index”, not 1
            tmp.add(i);
            dfs(n, i + 1, tmp, k - 1, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}