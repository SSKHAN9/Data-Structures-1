// The methods in this package are adapted from the code provided with:
//   Java Foundations (2nd & 3rd ed) by  Lewis, DePasquale, & Chase
//   Algorithms (4th ed) by Sedgewick & Wayne

package csc205;

import java.util.ArrayList;

import jsjf.ArrayHeap;

public class Sorting {

	// Helper methods
	// These operations will occur multiple times in our sorting methods,
	//   so we add methods for them here

	private static <T extends Comparable<T>> boolean less_than(T a, T b) {
		return (a.compareTo(b) < 0);
	}
	private static <T extends Comparable<T>> boolean less_than_equal(T a, T b) {
		return (a.compareTo(b) <= 0);
	}
	private static <T extends Comparable<T>> boolean greater_than(T a, T b) {
		return (a.compareTo(b) > 0);
	}
	private static void swap(Object[] a, int ii, int jj) {
		Object swap = a[ii];
		a[ii] = a[jj];
		a[jj] = swap;
	}
	public static <T extends Comparable<T>> 
	boolean isSorted(T[]data){
		return isSorted(data, 0, data.length-1);
	}
	public static <T extends Comparable<T>> 
	boolean isSorted(T[]data, int min, int max){
		for (int ii=min+1; ii<=max; ii++) {
			if (less_than(data[ii], data[ii-1]))
				return false;
		}
		return true;
	}

	// Selection Sort
	public static <T extends Comparable<T>> 
		void selectionSort (T[] data) {
		selectionSort (data, 0, data.length-1);
	}

	public static <T extends Comparable<T>> 
		void selectionSort (T[] data, int min, int max) {

		int indexOfSmallest;  // Smallest element found this pass
		
		min = Math.max(min, 0);
		max = Math.min(max, data.length-1);
		
		// ii is the starting point for each pass
		for(int ii=min; ii <= max; ii++ ) {
            indexOfSmallest = ii;
            for (int scan=ii+1; scan<=max; scan++) {
            	if (less_than(data[scan], data[indexOfSmallest])) {
            		indexOfSmallest = scan;
            	}
            }
            swap(data, indexOfSmallest, ii);
		}

	}
	
    public static <T extends Comparable<T>> 
	void insertionSort(T[] data) {
    	insertionSort(data, 0, data.length-1);
    }

    public static <T extends Comparable<T>> 
	void insertionSort(T[] data, int min, int max)
    {
    	int start = Math.max(min,  1);
    	int end = Math.min(max,  data.length-1);
    	
        for (int index = start; index <= end; index++)
        {
            int position = index;
			
            // shift larger values to the right 
            while (position > 0 && greater_than(data[position-1],data[position]))
            {
                swap(data, position, position-1);
                position--;
            }
        }
    }

    public static <T extends Comparable<T>> 
	void bubbleSort(T[] data) {
    	bubbleSort(data, 0, data.length-1);
    }
    public static <T extends Comparable<T>> 
	void bubbleSort(T[] data, int min, int max) {
        int position, scan;
        
		min = Math.max(min, 0);
		max = Math.min(max, data.length-1);
		
        // position is the "stopping point" for each pass
        for (position = max; position >= min; position--)
        {
            for (scan = 0; scan < position; scan++)
            {
                if (greater_than(data[scan],data[scan+1]))
                    swap(data, scan, scan + 1);
            }
        }
    }

    
	public static <T extends Comparable<T>>
	void mergeSort(T[] data) {
		mergeSort(data, 0, data.length-1);
	}

	private static <T extends Comparable<T>>
	void mergeSort(T[] data, int min, int max) {
		if (min < max)
		{
			int mid = min + ((max - min) / 2);
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}
	
	private static <T extends Comparable<T>>
	void merge(T[] data, int first, int mid, int last) {
		T[] temp = (T[])(new Comparable[data.length]);  // temp array
		
		// The two subarrays have already been sorted
		int first1 = first, last1 = mid;   // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		// while both sub arrays have items left
		while (first1 <= last1 && first2 <= last2)
		{
			if (less_than(data[first1],data[first2]))
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		// Only one of the while loops below will execute
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
	}

	public static <T extends Comparable<T>> 
	void quickSort(T[] data) {
		quickSort(data, 0, data.length-1);
	}

	private static <T extends Comparable<T>> 
	void quickSort(T[] data, int min, int max) {
		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max);
			
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);
			
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}

	private static <T extends Comparable<T>> 
	int partition(T[] data, int min, int max) {
		T partitionelement;
		int left, right;
		int middle = min + ((max - min) / 2);
		
		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		
		left = min;
		right = max;
		
		while (left < right)
		{
			// search for an element that is > the partition element
			while (left < right && less_than_equal(data[left],partitionelement))
				left++;
			
			// search for an element that is < the partition element
			while (greater_than(data[right], partitionelement))
				right--;
			
			// swap the elements
			if (left < right)
				swap(data, left, right);
		}
		
		// move the partition element into place
		swap(data, min, right);
		
		return right;
	}

	
	public static <T> void heapSort(T[] data) 
	{
		ArrayHeap<T> heap = new ArrayHeap<T>();

		// copy the array into a heap 
		for (int i = 0; i < data.length; i++)
			heap.addElement(data[i]);

		// place the sorted elements back into the array 
		int count = 0;
		while (!(heap.isEmpty()))
		{
			data[count] = heap.removeMin();
			count++;
		}
	}
	
	
	public static <T extends Comparable<T>> ArrayList<T> smallest_n(T[] data, int n) {
        // Project 9 - Returns ALL elements of data - modify to 
        //               return only n elements

        ArrayList<T> ret = new ArrayList<T>();
        ArrayHeap<T> myHeap = new ArrayHeap<T>();
        
        for (T e : data) {
            myHeap.addElement(e);
        }
        
        
        for(int ii=0; ii<n; ii++) {
            ret.add(myHeap.removeMin());
        }
        
        return ret;
    }
}
