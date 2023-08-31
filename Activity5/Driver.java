package week3;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
	Task taskList = new Task();
	
	Scanner scan = new Scanner(System.in);
	
	boolean exit = false;
	
	
	for (int i = 0; i < 5 ; i++ ) {
		System.out.println("Enter Priority for the following task: (1 to 5) ");
		System.out.println(taskList.getTask(i));
		int priority_num = scan.nextInt();
		taskList.setPriority(priority_num, i);
		System.out.println();
			
	}
	
	do {
		System.out.println("Get Priority Number for the following Tasks. (Enter exit to exit)");
		System.out.println("A. Do Laundry"
							+ "\nB. Complete Assignments"
							+ "\nC. Have Breakfast"
							+ "\nD. Attend Class"
							+ "\nE. Go for a run");
		
		String task_option = scan.next();
		
		if (task_option.equalsIgnoreCase("A")) { 
			System.out.println("Priority Number is: " + taskList.getPriority("Do Laundry"));
		} else if (task_option.equalsIgnoreCase("B")) { 
			System.out.println("Priority Number is: " + taskList.getPriority("Complete Assignments"));
		} else if (task_option.equalsIgnoreCase("C")) { 
			System.out.println("Priority Number is: " + taskList.getPriority("Have Breakfast"));
		} else if (task_option.equalsIgnoreCase("D")) { 
			System.out.println("Priority Number is: " + taskList.getPriority("Attend Class"));
		} else if (task_option.equalsIgnoreCase("E")) { 
			System.out.println("Priority Number is: " + taskList.getPriority("Go for a run"));
		} else if (task_option.equalsIgnoreCase("exit")) { 
			exit = true;
		}
		
		System.out.println();
	} while (exit != true);
	
		
	}

}
