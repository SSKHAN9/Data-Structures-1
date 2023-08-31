package actitivities;

import java.lang.*;
import java.text.DecimalFormat;

public class Point {
	
	private int x_coordinate;
	private int y_coordinate;
	
	
	Point(int x, int y) {
		x_coordinate = x;
		y_coordinate = y;
	}

	public void shiftX(int i) {
		x_coordinate += i;
	}

	public void shiftY(int i) {
		y_coordinate += i;
	}

	public void rotate(double d) {
		x_coordinate = (int) ((x_coordinate)*(Math.cos(d)) - (y_coordinate)*(Math.sin(d)));
		y_coordinate = (int) ((x_coordinate)*(Math.sin(d)) + (y_coordinate)*(Math.cos(d)));
	}

	public String swap() {
		int buffer;
		buffer = x_coordinate;
		x_coordinate = y_coordinate;
		y_coordinate = buffer;
		return "( " + x_coordinate + " , " + y_coordinate + " )";
	}
	
	public String distance() {
		DecimalFormat df = new DecimalFormat("#.00");
		double y_distance = Math.abs(y_coordinate - 0);
	    double x_distance = Math.abs(x_coordinate - 0);
	        
	    return  df.format(Math.hypot(y_distance, x_distance));
	}
	
	public String distance(Point p2) {
		DecimalFormat df = new DecimalFormat("#.00");
		double y_distance = Math.abs(p2.y_coordinate - y_coordinate);
	    double x_distance = Math.abs(p2.x_coordinate - x_coordinate);
	        
	    return  df.format(Math.hypot(x_distance, y_distance));
	}

	public String toString() {
		return "( " + x_coordinate + " , " + y_coordinate + " )";
	}
}
