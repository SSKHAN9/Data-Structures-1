
import java.util.Random;

import csc205.Sorting;

public class SortingTester {

	enum SortType {SELECTION, INSERTION, BUBBLE, MERGE, QUICK};
	
	public static void main(String args[]) {
		Integer[] a = new Integer[100];
		Random rand = new Random();
		int failures = 0;
		SortType sortType = SortType.SELECTION;
		
		for (int kk=0; kk<50; kk++) {
		    for (int ii=0;ii<a.length;ii++) {
		    	a[ii] = rand.nextInt(1000);
		    }
		    
		    System.out.print("\nUnsorted: ");
		    printArray(a);
		    		    
		    if (sortType == SortType.SELECTION) {
		    	Sorting.selectionSort(a);
		    }
		    if (sortType == SortType.INSERTION) {
		    	Sorting.insertionSort(a);
		    }
		    if (sortType == SortType.BUBBLE) {
		    	Sorting.bubbleSort(a);
		    }
	        if (sortType == SortType.MERGE) {
		    	Sorting.mergeSort(a);
		    }
		    if (sortType == SortType.QUICK) {
		    	Sorting.quickSort(a);
		    }
		    System.out.print("  Sorted: ");
		    printArray(a);   
		    
		    if (!Sorting.isSorted(a)) {
		    	System.out.println("Fail!");
		    	failures++;
		    }
		}
		
		System.out.println();
	    if (failures == 0) {
	    	System.out.println("Test successful! (" + failures + " failures)");
	    }
	    else {
	    	System.out.println("Test unsuccessful! (" + failures + " failures)");   	
	    }

	}
	
	public static void printArray(Object[] a) {
		for (int ii=0;ii<a.length;ii++) {
			System.out.print (a[ii] + " ");
		}
		System.out.println();
	}
}
