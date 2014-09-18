package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Rectangle {

    private double height;
    private double width;
    private final Point origin = new Point(0, 0);
    private Point center = new Point(0, 0);

    public Rectangle (double h, double w) {
        if (h == null || w == null) {// same problem with incomparable types
            throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
        }
        this.height = h;
        this.width = w;
    }
    
    public String toString() {
        return height + " by " + width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return (2 * height) + (2 * width);
    }

    public boolean containsPoint(int x, int y) {
        return Math.abs(y) < Math.abs(center.getY()) && (Math.abs(x) < Math.abs(center.getX()));
    }
    
    public Point translate(int x, int y) {
        int xTrans = center.getX() + x;
        int yTrans = center.getY() + y;
        center = new Point(xTrans,yTrans); //this is meant to change the assignment for the center position of the circle.
        return center; //should this be a string clarifying that this is meant to be the new center point?
    }
    
    public String getBoundingRectancle() {
        Rectangle bounding = new Rectangle(height,width);
        return "The bounding rectangle is centered at " + center + " and has a height and width of" + height + " and " + width + " respectively.";
    }
}