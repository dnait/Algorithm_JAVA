////checks whether an int is prime or not.
public class checkPrimer {
	public static void main(String[] args) {
		if (isPrimer(20)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}
	private static boolean isPrimer(int x) {
		for (int i = 2; i * 2 < x; i++) {
			if (x % i == 0) return false;					
		}
		return true;
	}
}