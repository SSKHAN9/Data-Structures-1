package project6;
import project6.jsjf.*;

public class Project6TestDriver {
	public static void main(String[] args) {

		LinkedQueue<String> q = new LinkedQueue<String>();
		LinkedStack<String> s = new LinkedStack<String>();

		// Queue testing
		q.enqueue("FAIL");
		q.enqueue("FRONTTESTGOOD");
		q.enqueue("the");
		q.enqueue("LinkedQueue");
		q.dequeue();
		q.enqueue("works!");
		
		
		System.out.println("\n\n=============== QUEUE TESTING ===============");
		System.out.println("Queue toString():\n------------ \n" + q + "------------");
		System.out.println("Queue size: " + q.size());
		System.out.println("Queue front: " + q.first());
		q.dequeue();
		q.dequeue();
		while (!q.isEmpty()) {
			System.out.print(q.dequeue() + " ");
		}
		
		// Stack testing
		s.push("works");
		s.push("LinkedStack");
		s.push("FAIL");
		s.pop();
		s.push("The");
		s.push("Wrong");
		
		System.out.println("\n\n=============== STACK TESTING ===============");
		System.out.println("Stack toString():\n------------ \n" + s + "------------");
		System.out.println("Stack size: " + s.size());
		s.push("FRONTTESTGOOD");
		System.out.println("Stack front: " + s.peek());
		s.pop();
		System.out.println("LinkedStack: Nothing " + s.pop());
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}
