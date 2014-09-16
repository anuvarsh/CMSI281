package edu.lmu.cmsi.anu.cartesianGraphs;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals; 
import java.util.*;

public class RightTriangle {
    private double height;
    private double width;
    private final Point origin = new Point(0, 0);
    private Point center = new Point(0, 0);
    
    public RightTriangle(double h, double w) {
        if (h == null || w == null) {
            throw new IllegalArgumentException ("Please make sure all constructor parameters are filled.");
        }
        this.height = h;
        this.width = w;
    }

    public String toString() {
        return height + " by " + width + " centered at " + center;
    }
    
    public double getArea() {
        return (1/2) * height * width;
    }
    
    public double getPerimeter() {
        return height + width + Math.sqrt(height*height + width*width);
    }
    
    public boolean containsPoint() {
        return //Daddy this is very difficult for me and I am so tired :(
    }
    
    public //need to add translate method
    
    public String getBoundingRectangle() {
        //this doesn't seem right at all either...
        Rectangle bounding = new Rectangle(height,width); 
        return "The bounding rectangle is centered at " + center + " and has a height and width of" + bounding;
    }
    
}