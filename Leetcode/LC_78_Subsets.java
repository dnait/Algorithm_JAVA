//78. Subsets
//Given a set of distinct integers, nums, return all possible subsets.
//Note: The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> tmp, int level, List<List<Integer>> res) {
        if (level == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        dfs(nums, tmp, level + 1, res);
        tmp.add(nums[level]);
        dfs(nums, tmp, level + 1, res);
        tmp.remove(tmp.size() - 1);
    }
}