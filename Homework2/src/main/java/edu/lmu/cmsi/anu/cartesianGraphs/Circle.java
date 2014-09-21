package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Circle {
    private double radius;
    private final Point origin = new Point (0,0);
    private Point center;
    
    public void Circle (double radiusValue) {
        if (radius == null) { //this is apparently wrong because the types don't match?
            throw new IllegalArgumentException("Please make sure all constructor parameters are filled.");
        }
        this.radius = radiusValue
        this.center = new Point(radius, radius);
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
    
    public boolean containsPoint(Point test) {
        return test.distanceBetween(center) < radius;
    }
    
    public Point translate(Point trans) {
        int xTrans = center.getX() + trans.getX();
        int yTrans = center.getY() + trans.getY();
        center = new Point(xTrans,yTrans);
        return center;
    }
    
    public Rectangle getBoundingRectangle() {
        double side = 2 * radius;
        Rectangle bounding = new Rectangle(side,side);
        return "The bounding rectangle is centered at " + center 
        + " and has a height and width of" + bounding.getHeight() + " and " + bounding.getWidth() + " respectively."; 
    }
}