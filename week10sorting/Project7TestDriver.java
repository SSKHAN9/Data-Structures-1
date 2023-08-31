
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import csc205.*;
import cards.Deck;

public class Project7TestDriver {

	public final static int LENGTH = 30;
	
	public static void main(String[] args) {
		Integer a[] = new Integer[LENGTH];

		a = generateRandomArray(LENGTH);

	    // Test sort()
	    System.out.println("Testing sort():");
	    System.out.print("Before sorting: ");
	    printArray(a);
	    Sorting.sort(a);
	    System.out.print("After sorting: ");
	    printArray(a);
	    testSortedArray(a);
	    System.out.println();

	    // test cutoff_qsort
		a = generateRandomArray(LENGTH);
	    System.out.println("Testing cutoff_sort():");
	    System.out.print("Before sorting: ");
	    printArray(a);
	    Sorting.cutoff_qsort(a);
	    System.out.print("After sorting: ");
	    printArray(a);
	    testSortedArray(a);
	    System.out.println();
	    
	    // test cutoff_qsort with cutoff value
		a = generateRandomArray(LENGTH);
	    System.out.println("Testing cutoff_sort():");
	    System.out.print("Before sorting: ");
	    printArray(a);
	    Sorting.cutoff_qsort(a, 5);
	    System.out.print("After sorting: ");
	    printArray(a);
	    testSortedArray(a);

		// closest_pair()
		System.out.println("\nTesting closest_pair)");
		Integer close1[] = {1,2,4,5,8,10};
		System.out.println("Closest pair {1,2,4,5,8,10} = " + Sorting.closestPair(close1));
		Integer close2[] = {2,4,5,6,8,10};
		System.out.println("Closest pair {2,4,5,6,8,10} = " + Sorting.closestPair(close2));
		Integer close3[] = {2,4,6,8,10,11};
		System.out.println("Closest pair {2,4,6,8,10,11} = " + Sorting.closestPair(close3));

	    // shuffle()
	    System.out.println("\nTesting shuffle():");
		Deck d = new Deck(52);
		System.out.print("Before shuffling: ");
		System.out.println(d);
		d.shuffle();
		System.out.print("After shuffling:  ");
		System.out.println(d);

	}
	

	// ----------- Helper functions --------------
	public static void printArray(Object[] a) {
		for (int ii=0;ii<a.length;ii++) {
			System.out.print (a[ii] + " ");
		}
		System.out.println();
	}
	
	public static Integer[] generateRandomArray(int len) {
		Integer[] a = new Integer[len];
		Random rand = new Random();

	    for (int ii=0;ii<a.length;ii++) {
	    	a[ii] = rand.nextInt(1000);
	    }			
	    return a;
	}
	
	public static <T extends Comparable<T>>  
	void testSortedArray(T[] a) {
		if (Sorting.isSorted(a)) {
			System.out.println("The array is sorted!");
		}
		else {
			System.out.println("The array is NOT sorted!");
		}
	}
}


