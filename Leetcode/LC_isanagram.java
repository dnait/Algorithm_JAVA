public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] letters = new int[26];
        for (char c: s.toCharArray()) {
            letters[c -'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--letters[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}