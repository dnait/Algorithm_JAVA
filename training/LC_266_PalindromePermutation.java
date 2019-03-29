//266. Palindrome Permutation
//Given a string, determine if a permutation of the string could form a palindrome.
//For example,
//“code" -> False, "aab" -> True, "carerac" -> True.

//HashSet will be the faster one.
public class Solution {
    public boolean canPermutePalindrome(String s) {
        //HashSet
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        if (set.size() <= 1) return true;
        return false;
    }
}

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