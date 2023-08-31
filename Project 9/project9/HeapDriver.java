package project9;

import java.util.Arrays;
import java.util.ArrayList;
import jsjf.ArrayHeap;
import jsjf.HeapQueue;
import jsjf.HeapStack;
import priorityqueue.PriorityQueue;


public class HeapDriver {
	public static <T> void main(String[] args)
	{
		PriorityQueue<Object> pq = new PriorityQueue<>();
		HeapQueue<Object> hq = new HeapQueue<>();
		HeapStack<Object> hs = new HeapStack<>();
		ArrayList<String> smallest = new ArrayList<>();
		
		hq.enqueue("This");	
		hq.enqueue("is");
		hq.enqueue("my");
		hq.enqueue("heaps");	
		hq.enqueue("project");	
		hq.enqueue("for");
		hq.enqueue("CSC205");
	
		System.out.println("Output for Queue Heap\n");

		while(!hq.isEmpty()) {
			System.out.println(hq.dequeue());
		}
		
		System.out.println();
		
		hs.push("This");
		hs.push("is");
		hs.push("my");	
		hs.push("heaps");	
		hs.push("project");	
		hs.push("for");	
		hs.push("CSC205");
		
		System.out.println("Output for Stack Heap\n");
		
		int size = hs.size();
		for(int i = 0; i < size; i++) {
			System.out.println(hs.pop());
		}
		
		System.out.println();
		
		
		pq.addElement("This", 0);
		pq.addElement("is", 2);
		pq.addElement("my", 1);
		pq.addElement("heaps", 3);
		pq.addElement("project", 4);
		pq.addElement("for", 5);
		pq.addElement("CSC205", 6);
		
		System.out.println("Output for Min Heap\n");

		while (!pq.isEmpty())
		{
			System.out.println(pq.removeNext());
		}
		
		System.out.println();
		
		System.out.println("Output for smallest_n");
		
		System.out.println();
		
		String[] str = {"this", "is", "my", "heaps" , "project", "for", "csc205"};
		
		smallest = smallest_n(str , 4);
		
		System.out.println(smallest);
		
	}
	
	//method was not working in sorting.java so i copied it here to test it
	
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

