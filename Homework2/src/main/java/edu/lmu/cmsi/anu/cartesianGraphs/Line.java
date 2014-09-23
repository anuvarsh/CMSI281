package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.Point;

public class Line {

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
        if((stpt.getX() == enpt.getX()) && (stpt.getY() == enpt.getY())) {
            throw new IllegalArgumentException("Please make sure the two points are not the same");
        }
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
        double s1x, s1y, s2x, s2y;
        double p1x, p2x, p1y, p2y;
        double p3x, p4x, p3y, p4y;

        //retrieving x and y values for each necessary point in the test and constructed line
        p1x = stpt.getX();
        p2x = enpt.getX();
        p1y = stpt.getY();
        p2y = enpt.getY();
        p3x = test.getStartPoint().getX();
        p4x = test.getEndPoint().getX();
        p3y = test.getStartPoint().getY();
        p4y = test.getEndPoint().getY();

        //finding the distance between corresponding x and y values
        s1x = p2x - p1x;
        s1y = p2y - p1y;
        s2x = p4x - p3x;
        s2y = p4y - p3y;

        //a mathematic algorithm that checks if two line segments are intersecting
        double s, t;
        s = (-s1y * (p1x - p3x) + s1x * (p1y - p3y)) / (-s2x * s1y + s1x * s2y);
        t = ( s2x * (p1y - p3y) - s2y * (p1x - p3x)) / (-s2x * s1y + s1x * s2y);
        return (s >= 0 && s <= 1 && t >= 0 && t <= 1);

    }
        
    public double length() {
        return stpt.distanceBetween(enpt);
    }

}