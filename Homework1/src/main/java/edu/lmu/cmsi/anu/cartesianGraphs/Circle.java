package edu.lmu.cmsi.anu.cartesianGraphs;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals; 
import java.util.*;

public class Circle {
    private double radius;
    private final Point origin = new Point (0,0);
    private Point center = new Point(0,0);
    
    public void Circle (double radiusValue) {
        if (radius == null) { //this is apparently wrong because the types don't match?
            throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
        }
        this.radius = radiusValue;
    }

    public String toString() {
        return "Circle of radius " + radius + " centered at " + center;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getDiameter() {
        return radius * 2;
    }
    
    public double getArea() {
        return radius*radius*Math.PI;
    }
    
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    public boolean containsPoint(int xVal, int yVal) {
        //a method that indicates whether or not a point is within the shape
        Point test = new Point (xVal, yVal);
        //if distance between parameters were Point type, would just put origin in this parameter
        return test.distanceBetween(0,0) < radius;
    }
    
    public Point translate(int x, int y) {
        int xTrans = center.getX() + x;
        int yTrans = center.getY() + y;
        center = new Point(xTrans,yTrans); //this is meant to change the assignment for the center position of the circle.
        return center;
    }
    
    public Line getBoundingRectangle() {
        //create a method that finds the rectangle that surroundes this circle according to the new 
        return null; //placeholder
    }
}