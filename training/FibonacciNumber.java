//Fibonacci Number
public class FibonacciNumber {
  // Method 1: recursion, this method will timeout
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0;
    }
    if (K == 1) {
      return 1;
    }
    return fibonacci(K - 1) + fibonacci(K - 2);
  }
  
  // Method 2: dp solution with O(n) space.
  public long fibonacciI(int K) {
    if (K <= 0) {
      return 0;
    }
    long[] array = new long[K + 1];
    array[1] = 1;
    for (int i = 2; i <= K; i++) {
      array[i] = array[i - 2] + array[i - 1];
    }
    return array[K];
  }
  
  // Method 3: dp solution with O(1) space.
  public long fibonacciII(int K) {
    long a = 0;
    long b = 1;
    if (K <= 0) {
      return a;
    }
    while (K > 1) {
      long temp = a + b;
      a = b;
      b = temp;
      K--;
    }
    return b;
  }
}
