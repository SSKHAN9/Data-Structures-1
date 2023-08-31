package Project4;

public class Recursion {
	
	public static int power(int x, int y) {
		
		int ans = 1;
		
		if ( y == 0) {
			return 1;
		}
		
		for (int i = 0; i < y; i++) {
			ans *= x;
		}
		return ans;
		
	}
	
	public static void triangle(int n) {
		int i = 0;
			if (i <= n) {
				for (int j = 1; j <=n; j++) {
					for (int k = 1; k <= j; k++ ) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			for (int l = ( n + (n-1)); l >= n; l--) {
				for (int m = l ; m >= n+1; m-- ) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

	public static int fib(int n) {
		
		int previousNumber = 0;
		int nextNumber = 1;
		int sum = 0;
		
		if (n <= 0) {
			return 0;
		}
		
		for (int i = 1; i <= n; ++i) {
			sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
			
		}
		return sum;
	}
	
	
}
