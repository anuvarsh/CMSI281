package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Line {
	//need to create two points to function as either end of the line
    //other option: should I create two point types and put that into a constructor? or would that nedlessly complicate the construction process?

    // y = mx + c
    private double m;
    private double c;
    private Point stpt;
    private Point enpt;

	public Line(Point sp, Point ep) { 
            this.m = (ep.getY() - sp.getY())/(ep.getX() - sp.getX());
            this.c = sp.getY() - m*sp.getX();
            this.stpt = sp;
            this.enpt = ep;
            this.checkLine();
	}

    public String toString() {
        return stpt.toString() + ", " + enpt.toString();
    }

	public Point getStartPoint() {
        return stpt;
	}

	public Point getEndPoint() {        
		return enpt;
	}

	public void checkLine() {
        //create a check for the line. once again, what should i check?
    }
        
    public Point midpoint() {
        double xMid = ((enpt.getX()+stpt.getX())/2);
        double yMid = ((enpt.getY()+stpt.getY())/2);
        return new Point(xMid, yMid);
    }
        
    public boolean equality(Line test) {
        return ((stpt.getX() == test.getStartPoint().getX()) && (stpt.getY() == test.getStartPoint().getY()) 
            && (enpt.getX() == test.getEndPoint().getX()) && (enpt.getY() == test.getEndPoint().getY()));
    }
        
    public boolean intersectingLines(Line test) {
        //insert code here -- not sure how to approach this right now
        //should return the point at which the lines intersect, if they do
        double s1_x, s1_y, s2_x, s2_y;
        double p0_x, p1_x, p0_y, p1_y;
        double p2_x, p3_x, p2_y, p3_y;
        p0_x = stpt.getX();
        p1_x = enpt.getX();
        p0_y = stpt.getY();
        p1_y = enpt.getY();
        p2_x = test.getStartPoint().getX();
        p3_x = test.getEndPoint().getX();
        p2_y = test.getStartPoint().getY();
        p3_y = test.getEndPoint().getY();

        s1_x = p1_x - p0_x;
        s1_y = p1_y - p0_y;
        s2_x = p3_x - p2_x;
        s2_y = p3_y - p2_y;

        double s, t;
        s = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / (-s2_x * s1_y + s1_x * s2_y);
        t = ( s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / (-s2_x * s1_y + s1_x * s2_y);

        return (s >= 0 && s <= 1 && t >= 0 && t <= 1);

    }
        
    public double length() {
        return stpt.distanceBetween(enpt);
    }

    /*public static void main (String[] args) {
        Point p1 = new Point(10.45, 20.78);
        Point p2 = new Point(0.45, 0.78);
        Point p3 = new Point(100, 100);
        Point p4 = new Point(110, 110);
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        System.out.println(l1);
        System.out.println(l1.midpoint());
        System.out.println(l1.length());
        System.out.println(l1.intersectingLines(l2));
    }
    */
}