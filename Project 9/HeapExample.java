package videoexamples.module14;

import videoexamples.module14.jsjf.LinkedBinarySearchTree;
import videoexamples.module14.jsjf.LinkedBinaryTree;
import videoexamples.module14.jsjf.LinkedHeap;

public class HeapExample {

	public static void main(String[] args) {
		LinkedHeap<Integer> t = new LinkedHeap<Integer>();
		LinkedHeap<StudentRecord> s = new LinkedHeap<StudentRecord>();
		LinkedBinarySearchTree<Integer> k = new LinkedBinarySearchTree<Integer>();
		
		for(int ii=0;ii<20;ii++) {
			int num = (int)(Math.random()*100);
			t.addElement(num);
			k.addElement(num);
		}
		
		s.addElement(new StudentRecord("Harrison Ford", 3.5));
		s.addElement(new StudentRecord("Mark Hamil", 3.1));
		s.addElement(new StudentRecord("Carrie Fisher", 3.1));
		s.addElement(new StudentRecord("Adam Driver", 3.8));
		s.addElement(new StudentRecord("Daisy Ridley", 3.3));
		s.addElement(new StudentRecord("John Boyega", 3.3));
		s.addElement(new StudentRecord("Oscar Isaac", 3.3));
		s.addElement(new StudentRecord("Lupita Nyong'o", 3.9));
		s.addElement(new StudentRecord("Andy Serkis", 3.3));
		s.addElement(new StudentRecord("Domhnall Gleeson", 3.4));
	
		System.out.println("Tree k: " + k);
		System.out.println("Heap t: " + t);
		System.out.println("Heap s: " + s);

		System.out.println("\nremoveMin testing s:");
		for(int x=0; x<4; x++) {
			System.out.println(s.removeMin());
		}	
		
		System.out.println("\nremoveMin testing t:");
		for(int x=0; x<4; x++) {
			System.out.println(t.removeMin());
		}
		

	}

}
