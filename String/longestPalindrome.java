public class longpalString {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) return s;
	    	int len = s.length();
	    	String longest = "";
	    	boolean[][] isPal = new boolean[len][len];

	    	for (int i = len - 1; i >= 0; i--) {
	    		for (int j = i; j <= len - 1; j++) {
	    			 if ((s.charAt(i)  == s.charAt(j) ) && (j - i <= 1 || isPal[i + 1][j - 1])) {
	    			     isPal[i][j] = true;
	    			     if (j + 1 - i > longest.length()) { //attention; j is greater than i;
	    			       longest = s.substring(i, j + 1);
	    			     }
	    			  }
	    		  }
	    	}
	    	return longest;
	}

	public static void main(String[] args) {
		String s = "bb";
		System.out.println(longestPalindrome(s));

	}
}
