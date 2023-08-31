package actitivities;

public class Project1Driver {
	public static void main(String[] args) {
		Point p1 = new Point(2,4);
		Point p2 = new Point(-1, 8);
		Point p3 = new Point(0,1);
		
		System.out.println("Point 1: " + p1);
		System.out.println("Point 2: " + p2);
		System.out.println("Distance between " + p1 + " and " + 
				p2 + ": " + p1.distance(p2));
		System.out.println("Distance between " + p3 + " and origin " + ": " + p3.distance());
		p1.shiftX(3);
		p2.shiftY(-2); 
		System.out.println("\nAfter shift:");
		System.out.println("Point 1: " + p1);
		System.out.println("Point 2: " + p2);
		System.out.println("Distance: " + p1.distance(p2));
		System.out.println("\nRotate test:");
		System.out.println("Before rotate: Point 3: " + p3);
		p3.rotate(Math.PI / 2);
		System.out.println("After rotate: Point 3: " + p3);
		System.out.println();
		System.out.println("Swap Test");
		System.out.println("Point before swap: " + p2);
		System.out.println("Point after swap: " + p2.swap());
		p2.swap();
	}

}