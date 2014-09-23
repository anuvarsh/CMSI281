package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.*;
import java.util.*;

public class Rectangle {

    private double height;
    private double width;
    private final Point origin = new Point(0, 0);
    private Point corner1 = new Point(0, 0);
    private Point corner2;
    private Point corner3;
    private Point corner4;

    //Corner#'s assigned in a clockwise fashion, where corner1 is always the bottom left corner of the rectangle
    public Rectangle (double w, double h) {
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
        if ((height < 0) || (width < 0)) {
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
        return (test.getX() >= corner1.getX()) && (test.getX() <= corner3.getX()) 
            && (test.getY() <= corner3.getY()) && (test.getY() >= corner1.getY());
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
        this.height = corner1.distanceBetween(corner2);
        this.width = corner1.distanceBetween(corner4);
        return this;
    }
    
    public String getBoundingRectangle() {
        Rectangle bounding = new Rectangle(width,height);
        return "The bounding rectangle is cornered at " + corner1 + " and has a height and width of" + height + " and " + width + " respectively.";
    }
}