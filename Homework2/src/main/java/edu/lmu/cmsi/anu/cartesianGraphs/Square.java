package edu.lmu.cmsi.anu.cartesianGraphs;
import edu.lmu.cmsi.anu.cartesianGraphs.*;
import java.util.*;

public class Square {
    private double side;
    //private final Point origin = new Point(0, 0);
    private Point corner1 = new Point(0, 0); //bottom left
    private Point corner3; //top right
    private Point corner2; //top left
    private Point corner4; //bottom right

    //use bottom left corner point & length of a side (lenght of two sides in rectangle)

    public Square (double s) {
        this.side = s;
        this.corner2 = new Point(0,side);
        this.corner3 = new Point(side, side);
        this.corner4 = new Point(side, 0);
        this.checkInput();
    }

    public String toString() {
        return "Square bound by:" + corner1 + " " + corner2 + " " + corner3 + ", and " + corner4;
    }

    public void checkInput() {
        if (side <= 0) {
            throw new IllegalArgumentException("Please make sure all parameters are positive doubles.");
        }
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

    public boolean containsPoint(Point test) {
        return (test.getX() >= corner1.getX()) && (test.getX() <= corner3.getX()) 
            && (test.getY() <= corner3.getY()) && (test.getY() >= corner1.getY());
    }
    
    public Square translate(Point test) {
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
        return this;
    }

    public String getBoundingRectangle() {
        Rectangle bounding = new Rectangle(side,side); 
        return "The bounding rectangle is at cornered at" + corner1 
        + " and has a height and width of" + bounding.getHeight() + " and" + bounding.getWidth() + ".";
    }   
}
