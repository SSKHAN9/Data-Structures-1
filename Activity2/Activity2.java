package activities.activity2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class for CSC205 Activity 2
 * 
 * @author Saad Khan
 *
 */
public class Activity2 {

	public static void main(String[] args) {

		Fraction sampleFraction = new Fraction(8,3);
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
		
		System.out.print ("Enter the numerator:  ");
		sampleFraction.setNumerator(scan.nextInt());		
		System.out.print ("Enter the denominator:  ");
		sampleFraction.setDenominator(scan.nextInt());	

		System.out.println ("The fraction " + sampleFraction.getNumerator() + "/" +
				sampleFraction.getDenominator() + " is equal to " + sampleFraction.toMixedNumber());
		
		scan.close();
		
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e + ". \nPlease make sure denominator is greater than 0.");
		}  catch (InputMismatchException e) {
			System.out.println("Error: " + e + ". \nPlease make sure the number is an integer."
					+ "\nRange for numbers is greator than or equal to -10000000000 and"
					+ " \nless than or equal to 1000000000");
		} catch (Exception e) {
			System.out.println("Error: " + e + ". \nPlease re-enter the digits.");
		}

	}
}