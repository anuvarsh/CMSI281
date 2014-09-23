package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.*;
import java.util.*;

public class RightTriangle {
    private double height;
    private double width;
    private double hypotenuseLength;
    private Point corner1 = new Point(0, 0);
    private Point corner2;
    private Point corner3;
    
    public RightTriangle(double w, double h) {
        this.height = h;
        this.width = w;
        this.hypotenuseLength = Math.sqrt((height*height) + (width*width));
        this.corner2 = new Point(0,height);
        this.corner3 = new Point(width,0);
        this.checkInput();
    }

    public void checkInput() {
        if ((height < 0) || (width < 0)) {
            throw new IllegalArgumentException("Please make sure all parameters are positive doubles.");
        }
    }

    public String toString() {
        return "Triangle bound by " + corner1 + " " + corner2 + " " + corner3 + ".";
    }
    
    public double getArea() {
        return (1/2) * height * width;
    }
    
    public double getPerimeter() {
        return (height + width + hypotenuseLength);
    }
    
    public boolean containsPoint(Point test) {
        //d = (x - x1)(y2 - y1) - (y - y1)(x2 - x1)
        double tx = test.getX();
        double ty = test.getY();
        double x1 = corner1.getX();
        double y1 = corner1.getY();
        double x2 = corner2.getX();
        double y2 = corner2.getY();
        double x3 = corner3.getX();
        double y3 = corner3.getY();
        return ((tx - x1)*(y2 - y1) - (ty - y1)*(x2 - x1)) > 0 
            && ((tx - x2)*(y3 - y2) - (ty - y2)*(x3 - x2)) > 0 
            && ((tx - x3)*(y1 - y1) - (ty - y3)*(x1 - x3)) > 0;
    }
    
    
    public RightTriangle translate(Point test) {
        double tx = test.getX();
        double ty = test.getY();
        double x1 = corner1.getX();
        double y1 = corner1.getY();
        double x2 = corner2.getX();
        double y2 = corner2.getY();
        double x3 = corner3.getX();
        double y3 = corner3.getY();
        corner1 = new Point(tx+x1, ty+y1);
        corner2 = new Point(tx+x2, tx+y2);
        corner3 = new Point(tx+x3, tx+y3);
        double newH = corner1.distanceBetween(corner2);
        double newW = corner1.distanceBetween(corner3);
        return new RightTriangle(newH, newW);
    }
    
    public String getBoundingRectangle() {
        Rectangle bounding = new Rectangle(height,width); 
        return "The bounding rectangle is cornered at " + corner1 
        + " and has a height and width of" + bounding.getHeight() + " and " + bounding.getWidth() + " respectively.";
    }
    
}