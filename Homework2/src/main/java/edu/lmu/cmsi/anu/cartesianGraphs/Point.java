package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Point {
	private double x;
	private double y;

	public Point(double xVal, double yVal) {
		this.x = xVal;
		this.y = yVal;
		this.checkPoints();
	}

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void checkPoints() {
		if ((x < 0) || (y < 0)) {
            throw new IllegalArgumentException("Please make sure all parameters are positive doubles.");
        }
	}

	//Checks distance between point constructed and other point. 
	public double distanceBetween(Point test) {
        double tx = test.getX();
        double ty = test.getY();
		return Math.sqrt(((tx - x)*(tx - x)) + ((ty - y)*(ty - y)));
	}

	//Similar problem here, would like to give a Point type as a parameter.
	public boolean areEqual(Point test) {
		return ((test.getX() == x) && (test.getY() == y));
	}

    /*
    public static void main (String [] args) {
        Point p1 = new Point(10.45, 20.78);
        System.out.println(p1);
        Point p2 = new Point(10.45, 20.78);
        Point p3 = new Point(12.34, 11.23);
        System.out.println(p1.distanceBetween(p2));
        System.out.println(p1.areEqual(p2));
        System.out.println(p1.areEqual(p3));
        System.out.println(p1.distanceBetween(p3));
    }
    */
}


