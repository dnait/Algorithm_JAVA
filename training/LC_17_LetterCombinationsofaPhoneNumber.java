//17. Letter Combinations of a Phone Number
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keys = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;  //Add this, since need to return [], not [""]
        dfs(digits, keys, 0, new StringBuilder(), res);
        return res;
    }

    
    private void dfs(String digits, String[] keys, int index, StringBuilder sb, List<String> res) {
        if (digits.length() == index) {
            res.add(sb.toString());
            return;
        }
        String letter = keys[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            dfs(digits, keys, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}