package edu.lmu.cmsi.anu.cartesianGraphs;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals; 
import java.util.*;

public class Line {
	//need to create two points to function as either end of the line
    //other option: should I create two point types and put that into a constructor? or would that nedlessly complicate the construction process?
	private int x1;
	private int x2;
    private int y1;
    private int y2;
    private Point start = new Point (x1, y1);
    private Point end = new Point (x2, y2);

	public Line(int x1Val, int y1Val, int x2Val, int y2Val) { 
            if (x1Val == null || y1Val == null || x2Val == null || y2Val == null) {
                throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
            }
            this.x1 = x1Val;
            this.x2 = x2Val;
            this.y1 = y1Val;
            this.y2 = y2Val;
            this.checkLine();
	}

    public String toString() {
        return start + end;
    }

	public Point getStart() {
        return start;
	}

	public Point getEnd() {        
		return end;
	}

	public void checkLine() {
            //create a check for the line. once again, what should i check?
        }
        
        public String midpoint() {
            double xMid = ((x2+x1)/2);
            double yMid = ((y2+y1)/2);
            return "(" + xMid + ", " + yMid + ")";
        }
        
        public boolean equality(int ptXa, int ptYa, int ptXb, int ptYb) {
            return (x1 == ptXa && y1 == ptYa && x2 == ptXb && y2 == ptYb);
        }
        
        public Point intersectingLines() {
            //insert code here -- not sure how to approach this right now
            //should return the point at which the lines intersect, if they do
        }
        
        public double length() {
            Point interim = new Point (x1, y1);
            double length = interim.distanceBetween(x2, y2);
            return length;
        }
}