class Solution {
    public int reverse(int x) {
        //Integer.MAX_VALUE gives 2147483647
        //Integer.MIN_VALUE gives -2147483648
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
		int _x = Math.abs(x);
		int newNum = 0;
		while (_x / 10 != 0) {
			int remainder = _x % 10;
			_x = _x / 10;
            
            if((newNum + remainder) > Integer.MAX_VALUE / 10) return 0;
            
            newNum = newNum * 10 + remainder * 10;
            //might cause overflow if not check newNum range, like 1534236469 -> 1056389759

        }
        
         return x > 0 ? newNum + _x : -(newNum + _x);
    }
}
