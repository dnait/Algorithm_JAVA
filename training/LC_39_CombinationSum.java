39. Combination Sum

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, res, new ArrayList<Integer>(), 0, target);
        return res;
    }
    private void dfs(int[] candidates, List<List<Integer>> res, ArrayList<Integer> path, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            dfs(candidates, res, path, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}