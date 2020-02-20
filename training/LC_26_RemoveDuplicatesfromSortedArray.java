26. Remove Duplicates from Sorted ArrayGiven input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 1;
        //use two pointers, slow means all different numbers.
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                //udpate the array to make sure [slow, fast] has no repeats
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; 
    }
}