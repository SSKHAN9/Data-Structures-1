package week3;

public class Excersize {

	public static void main(String[] args) {
	
		Date d1 = new Date(05,19,2001);
		Date d2 = new Date("May", 12 ,2001);
		
		System.out.println("Day 1: " + d1.toString());
		System.out.println("Day 2: " + d2.toString());
		
		int order = d1.compareTo(d2);
		
		if (order > 0) {
			System.out.println("Day 2 comes first.");
		} else if (order == 0) {
			System.out.println("The dates are the same");
		} else if (order < 0) {
			System.out.println("Day 1 comes first.");
		}

	}

}
