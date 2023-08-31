package project6;

import project6.jsjf.LinkedStack;

public class driver6 {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();

        System.out.println("STACK TESTING");      

        System.out.println("The stack contains:\n" +

   		stack.toString());

       

        stack.push(3);

        stack.push(7);

        stack.push(4);

        System.out.println(stack.peek());

        stack.pop();       

        stack.push(9);

        stack.push(8);

        System.out.println(stack.peek());       

        System.out.println(stack.pop());

        System.out.println(stack.peek());       

       

        System.out.println("The size of the stack is: " +

   stack.size());

        System.out.println("The stack contains:\n" +

   stack.toString());  

    }
	}

