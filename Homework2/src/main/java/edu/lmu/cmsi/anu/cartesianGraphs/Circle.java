package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.*;
import java.util.*;
import java.lang.Object;

public class Circle {
    private double radius;
    private final Point origin = new Point (0,0);
    private Point center;
    
    public Circle (double radiusValue) {
        this.radius = radiusValue;
        this.center = new Point(radius, radius);
        this.checkValues();
    }

    public String toString() {
        return "Circle of radius " + radius + " centered at " + center;
    }

    public void checkValues() {
        if(radius < 0) {
            throw new IllegalArgumentException("Please make sure radius is a positive double.");
        }
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
    
    public Circle translate(Point trans) {
        double xTrans = center.getX() + trans.getX();
        double yTrans = center.getY() + trans.getY();
        this.center = new Point(xTrans,yTrans);
        return this;
    }
    
    public String getBoundingRectangle() {
        double side = 2 * radius;
        Rectangle bounding = new Rectangle(side,side);
        return "The bounding rectangle is centered at " + center 
        + " and has a height and width of" + bounding.getHeight() + " and " + bounding.getWidth() + " respectively."; 
    }
}