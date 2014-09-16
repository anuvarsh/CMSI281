package edu.lmu.cmsi.anu.cartesianGraphs;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals; 
import java.util.*;

public class Point {
	private int x;
	private int y;

	public void Point(int xVal, int yVal) {
		if (xVal == null || yVal == null) {
			throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
		}
		this.x = xVal;
		this.y = yVal;
		this.checkPoints();
	}

    public String toString() {
        return "(" + x ", " + y + ")";
    }
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void checkPoints() {
		//create a test to make sure points are valid... is this necessary in this case?
		//technically, there are no limitations on what the two points are...
	}

	//Checks distance between point constructed and other point. 
	public double distanceBetween(Point test) {
		double distance = Math.sqrt(((test.getX() - x)*(test.getX() - x)) + ((test.getY() - y)*(test.getY() - y)));
		return distance;
	}

	//Similar problem here, would like to give a Point type as a parameter.
	public boolean areEqual(Point test) {
		return (test.getX() == x && test.getY() == y);
	}
}
