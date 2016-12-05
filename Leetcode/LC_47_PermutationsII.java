/*47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        List<Integer> path = new ArrayList<Integer>();
        for (int x : nums) path.add(x);
        if (index == nums.length) {
            res.add(path);
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, i, index);
                dfs(nums, index + 1, res);
                swap(nums, i, index);
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}