public class Solution {
    public int singleNumber(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int x: nums) {
            sum ^= x;
        }
        return sum;
    }
}