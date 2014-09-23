package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.Point;
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

	public boolean areEqual(Point test) {
		return test.getX() == x && test.getY() == y;
	}
}


