public class findFactors {

	public static void main(String[] args) {
		 int x = 15;
		 checkFactor(x);
	}

	private static void checkFactor(int x) {
		if (x == 1) System.out.println(1);
		//need to i == x as well, or 5 will be missing
		for (int i = 2; i <= x; i++) {
			while(x % i == 0) {
				System.out.print(i + " ");
				x /= i;
			}
		}
	}
}