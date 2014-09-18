package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Square {
    private double side;
    private final Point origin = new Point(0, 0);
    private Point center = new Point(0, 0);

    public Square (double s) {
        if (h == null || w == null) {// same problem with incomparable types
            throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
        }
        this.side = s;
    }

    public String toString() {
        return "Side length: " + side + " centered at " + center;
    }
    
    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return (4 * side);
    }

    public boolean containsPoint(int x, int y) {
        return Math.abs(y) < Math.abs(center.getY()) && (Math.abs(x) < Math.abs(center.getX()));
    }
    
    public Point translate(int x, int y) {
        int xTrans = center.getX() + x;
        int yTrans = center.getY() + y;
        center = new Point(xTrans,yTrans); //this is meant to change the assignment for the center position of the circle.
        return "The new center point of the square is " + center + ". The height and width are the same."; 
    
    public String getBoundingRectancle() { //this doesn't seem right at all...
        Rectangle bounding = new Rectangle(side,side); 
        return "The bounding rectangle is centered at " + center + " and has a height and width of" + bounding ".";
    }   
}