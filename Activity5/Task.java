package week3;

public class Task implements Priority {
	
	String[] taskList = new String[5];
	String[] prioritizedList = new String[5];
	
	public Task() {
		taskList[0] = "Do Laundry";
		taskList[1] = "Complete Assignments";
		taskList[2] = "Have Breakfast";
		taskList[3] = "Attend Class";
		taskList[4] = "Go for a run";
	}
	
	public String getTask(int num) {
		return taskList[num];
	}
	
	@Override
	public int getPriority(String task) {
		
		int priority = -1;
		int i = 0;
		
		while (priority == -1 ) {
			if (prioritizedList[i].equals(task)) {
				priority = i + 1 ;
			}
			i++;
		}
		
		return priority;
	}
	
	@Override
	public void setPriority(int p, int num) {
		prioritizedList[(p-1)] = taskList[num];
	}
	

}
