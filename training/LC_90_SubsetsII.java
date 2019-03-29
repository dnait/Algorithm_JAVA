//90. Subsets II
//Given a collection of integers that might contain duplicates, nums, return all possible subsets.	
//Note: The solution set must not contain duplicate subsets.	
//For example,
//If nums = [1,2,2], a solution is:
//	
//	[
//	  [2],
//	  [1],
//	  [1,2,2],
//	  [2,2],
//	  [1,2],
//	  []
//	]


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }
    
    private void dfs(int[] nums, List<Integer> tmp, int index, List<List<Integer>> res) {
        res.add(tmp);
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            List<Integer> path = new ArrayList<>(tmp);
            path.add(nums[i]);
            dfs(nums, path, i + 1, res);
        }
    }
    
}