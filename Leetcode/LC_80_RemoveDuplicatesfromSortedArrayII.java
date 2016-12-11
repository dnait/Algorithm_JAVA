//80. Remove Duplicates from Sorted Array II
//Given sorted array nums = [1,1,1,2,2,3],
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}