class Solution {
    public boolean isPalindrome(int x) {
        //like lc_7, check if equal after transformation
        //skip extreme cases
        if (x < 0) return false;
        //remember to keep original copy of x
        int ori = x;
        int newX = 0;
        while ( x / 10 != 0) {
            int remainder = x % 10;
            x = x / 10;
            newX = newX * 10 + remainder * 10;
        }
        
        return newX + x == ori;
    }
}
