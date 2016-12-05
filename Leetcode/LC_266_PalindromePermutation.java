//266. Palindrome Permutation
//Given a string, determine if a permutation of the string could form a palindrome.
//For example,
//“code" -> False, "aab" -> True, "carerac" -> True.


//Just count the appearances of the characters. if odd appearances are greater than 1, then return false;
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] array = new int[256];
        for(char c : s.toCharArray()) {
            array[c]++;
        }
        int count = 0;
        for (int x : array) {
            if (x % 2 == 1) count++;
            if (count > 1) return false;
        }
        return true;
    }
}