//189. Rotate Array
//Rotate an array of n elements to the right by k steps.

//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].


public class Solution {
    public void rotate(int[] nums, int k) {
        //to the right by k steps.k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
        if (nums == null || k <= 0 || nums.length <= 1) return;  
        int len = nums.length;
        k %= len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] a, int left, int right) {
        while(left < right) {
            //swap array[left], array[right]
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }
}
