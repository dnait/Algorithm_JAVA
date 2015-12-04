

public class manacher {

	    public static String Manacher(String s) {
	    	String t = preprocess(s);  // transformed string
	        int[] p = new int[t.length()];   //p[i] = length of longest palindromic substring of t, centered at i

	        int center = 0;
	        int right = 0;
	        int longestlen = 0;
	        for (int i = 1; i < t.length() - 1; i++) {
	            int iMirror = 2 * center - i;            
	            p[i] = right > i ? Math.min(p[iMirror], right - i) : 0;
	            while (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
	 
	            // if palindrome centered at i expands past right,
	            // adjust center based on expanded palindrome.
	            // update the boundary and extend the center
	            if (i + p[i] > right) {
	                center = i;
	                right = i + p[i];
	            }
	            longestlen = Math.max(longestlen, p[i]);
	        }
	        String res = longestPalindromicSubstring(p, s);
	       return res;
	    }

	    // Transform s into t.
	    // For example, if s = "abba", then t = "$#a#b#b#a#@"
	    // the # are interleaved to avoid even/odd-length palindromes uniformly
	    // $ and @ are prepended and appended to each end to avoid bounds checking
	    private static String preprocess(String s) {
	    	//if (s.length() <= 1) return s; //or "a" cannot approve
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("$");
	    	for (int i = 0; i < s.length(); i++) {
	    		sb.append("#");
	    		sb.append(s.charAt(i));
	    	}
	    	sb.append("#@");
	    	return sb.toString();
	    }
	 
	    // longest palindromic substring
	    public static String longestPalindromicSubstring(int[] p, String s) {
	        int maxLen = 0;   // length of longest palindromic substring
	        int center = 0;   // center of longest palindromic substring
	        for (int i = 1; i < p.length; i++) {
	            if (p[i] > maxLen) {
	                maxLen = p[i];
	                System.out.println("p[i]" + maxLen);
	                center = i;
	            }
	        }
	        
	        return s.substring((center - 1 - maxLen) / 2, (center - 1 + maxLen) / 2);
	    }

	public static void main(String[] args) {
		String s = "a";
		System.out.println(Manacher(s));

	}

}
