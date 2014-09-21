package edu.lmu.cmsi.anu.cartesianGraphs;
import java.util.*;

public class Rectangle {

    private double height;
    private double width;
    private final Point origin = new Point(0, 0);
    private Point corner1 = new Point(0, 0);
    private Point corner2;
    private Point corner3;
    private Point corner4;

    public Rectangle (double h, double w) {
        this.corner2 = new Point(0, h);
        this.corner3 = new Point(w, h);
        this.corner4 = new Point(w, 0);
        this.height = h;
        this.width = w;
        this.checkInput();
    }
    
    public String toString() {
        return "Rectangle bound by:" + corner1 + " " + corner2 + " " + corner3 + ", and " + corner4;
    }

    public void checkInput() {
        if ((h < 0) || (w < 0)) {
            throw new IllegalArgumentException("Please make sure all parameters are positive doubles.");
        }
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return (2 * height) + (2 * width);
    }

    public boolean containsPoint(Point test) {
        return (test.getX() >= corner1.getX()) && (test.getY()<=corner3.getY());
    }
    
    public Rectangle translate(Point test) {
        double tx = test.getX();
        double ty = test.getY();
        double x1 = corner1.getX();
        double y1 = corner1.getY();
        double x2 = corner2.getX();
        double y2 = corner2.getY();
        double x3 = corner3.getX();
        double y3 = corner3.getY();
        double x4 = corner4.getX();
        double y4 = corner4.getY(); 
        corner1 = new Point(tx+x1, ty+y1);
        corner2 = new Point(tx+x2, tx+y2);
        corner3 = new Point(tx+x3, tx+y3);
        corner4 = new Point(tx+x4, tx+y4);
        double newH = corner1.distanceBetween(corner2);
        double newW = corner1.distanceBetween(corner4);
        return Rectangle(newH, newW);
    }
    
    public String getBoundingRectancle() {
        Rectangle bounding = new Rectangle(height,width);
        return "The bounding rectangle is cornered at " + corner1 + " and has a height and width of" + height + " and " + width + " respectively.";
    }

    public static void main (String [] args) {
        Rectangle ugh = new Rectangle(5, 10);
        Point trans = new Point(2, 4);
        System.out.println(ugh.translate(trans);
    }
}