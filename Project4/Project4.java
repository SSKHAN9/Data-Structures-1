package Project4;

import java.util.Arrays;
import java.util.List;

public class Project4 {

	public static void main(String[] args) {
		List<Integer> testValues = Arrays.asList(1, 5, 10, 20);
		
		System.out.println("Recursion Tests:");
		
		System.out.println("Class examples:");
		System.out.println("sum_up:");
		for (Integer ii : testValues) {
			System.out.print("[" + ii + "]: " + Recursion.sum_up(ii) + "   ");
		}
		System.out.println();
		System.out.println("sum_up_tail:");
		for (Integer ii : testValues) {
			System.out.print("[" + ii + "]: " + Recursion.sum_up_tail(ii) + "   ");
		}
		System.out.println();
		System.out.println("Activity 4:");

		// Test Fibonacci
		System.out.println();
		System.out.println("Fibonacci:");
		for (Integer ii : testValues) {
			System.out.print(Recursion.fib(ii) + "   ");
		}
		System.out.println();

		// Test power function
		System.out.println();
		System.out.println("Power:");
		for (Integer ii : testValues) {
			for (int jj = 0; jj<6; jj ++)  {
				System.out.print(ii + "^" + jj + "=" + Recursion.power(ii,jj) + "   ");
			}
			System.out.println();
		}

		// Test triangle method
		System.out.println();
		System.out.println("Triangle");
		Recursion.triangle(2);
		System.out.println();
		Recursion.triangle(4);
		

		System.out.println();
		// Test balance function 
		System.out.println("Balance:");
		System.out.print("[10 20]: " + Recursion.balance(10, 20) + "    ");
		System.out.print("[20 10]: " + Recursion.balance(20, 10) + "    ");
		System.out.print("[10 21]: " + Recursion.balance(10, 21) + "    ");
		System.out.println();
		System.out.print("[21 10]: " + Recursion.balance(21, 10) + "    ");
		System.out.print("[10 10]: " + Recursion.balance(10, 10) + "    ");
		System.out.print("[10 11]: " + Recursion.balance(10, 11) + "    ");
		System.out.println();

		// Test the Ackermann function 
		System.out.println();
		System.out.println("Ackermann:");
		testValues = Arrays.asList(1, 2, 3);
		for (Integer ii : testValues)
		{
			for (int jj = 0; jj < 5; jj++)
			{
				System.out.print(Recursion.Ackermann(ii,jj) + "\t");
			}
			System.out.println();
		}
		
		// Test the Pi approximation function 
		System.out.println();
		testValues = Arrays.asList(5, 20, 50);
		System.out.println("Pi:");
		for(Integer ii : testValues) {
			System.out.print("[" + ii + "] : " + 
					String.format("%.3f", Recursion.pi_approximation(ii)) +
					"     ");
		}
		System.out.println();

		// Test the Longest Substring function 
		System.out.println();
		System.out.println("Length of longest substring:");
		String a1 = "aaacsc250bbb";
		String b1 = "xxxcsc250yyy";
		System.out.println("Substring length of " + a1 + " and " + b1 + " is " + Recursion.lengthOfLongestSubsequence(a1, b1));
		a1 = "aaabbbccc";
		b1 = "xxxyyyzzz";
		System.out.println("Substring length of " + a1 + " and " + b1 + " is " + Recursion.lengthOfLongestSubsequence(a1, b1));
		a1 = "aaabbbccc";
		b1 = "xxxyyyaaa";
		System.out.println("Substring length of " + a1 + " and " + b1 + " is " + Recursion.lengthOfLongestSubsequence(a1, b1));
	}
}
