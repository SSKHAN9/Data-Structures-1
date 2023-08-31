package Project4;

import java.util.Arrays;
import java.util.List;

public class Activity4 {

	public static void main(String[] args) {
		List<Integer> testValues = Arrays.asList(1, 5, 10, 20);
		
		//removed class examples		

		System.out.println("Activity 4:");

		// Test fibonacci
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
		
	}
}
