package edu.lmu.cmsi.anu.cartesianGraphs;

import edu.lmu.cmsi.anu.cartesianGraphs.Point;
import edu.lmu.cmsi.anu.cartesianGraphs.Line;
import edu.lmu.cmsi.anu.cartesianGraphs.Square;
import edu.lmu.cmsi.anu.cartesianGraphs.Rectangle;
import edu.lmu.cmsi.anu.cartesianGraphs.Circle;
import edu.lmu.cmsi.anu.cartesianGraphs.RightTriangle;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class cartesianGraphsTest {

	private Point p1;
	private Point p2;
	private Line l1;
	private Line l2;
	private Square s1;
	private Rectangle r1;
	private Circle c1;
	private RightTriangle rt1;

	@Before
	public void initialize() {
		this.p1 = new Point(1.0,2.0);
		this.p2 = new Point(2.0,3.0);
		this.l1 = new Line(p1, p2);
		this.l2 = new Line(p2, p1);
		this.s1 = new Square(5.0);
		this.r1 = new Rectangle(5.0,10.0);
		this.c1 = new Circle(5.0);
		this.rt1 = new RightTriangle(10.0,10.0);
	}

	//Point Tests

	@Test
	public void pointInputTest() {		
		assertEquals("x values not equal", p1.getX(), 1.0, 2.0);
		assertEquals("y values not equal", p1.getY(), 2.0, 2.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void negativePoint() {
		Point p = new Point(-10.0,0.0);
	}

	@Test
	public void distanceBetweenTest() {
		assertEquals("failure - distance incorrect", Math.sqrt(2), p1.distanceBetween(p2), 4.0);
	}

	@Test
	public void areEqualTest() {
		assertTrue("failure - p1 not equal to p2", !p1.areEqual(p2));
	}

	//Line Tests

	@Test (expected = IllegalArgumentException.class)
	public void twoEqualPoints() {
		Line l = new Line(p1, p1);
	}

	@Test
	public void midpointTest() {
		Point midpoint = new Point(3.0 / 2.0, 5.0 / 2.0);
		assertEquals(midpoint, l1.midpoint());
	}

	@Test
	public void equalityTest() {
		assertFalse("failure - equality incorrect", l1.equality(l2));
	}

	@Test
	public void intersectingLinesTest() {
		assertFalse("failure - intersectingLines incorrect", l1.intersectingLines(l2));
	}

	@Test
	public void lengthTest() {
		double answer = Math.sqrt(2);
		assertEquals(answer, l1.length());
	}

	//Shapes

	@Test (expected = IllegalArgumentException.class)
	public void negativeRadius() {
		Circle c = new Circle(-10.0);
	}

	@Test 
	public void circleContainsPoint() {
		assertTrue("failure - containsPoint incorrect", c1.containsPoint(p2));
	}

	@Test
	public void circleTranslateTest() {
		Point ptest = new Point(1.0,1.0);
		Circle ctest = c1.translate(ptest);
		String result = "Circle of radius 5.0 centered at (6.0, 6.0)";
		assertEquals("failure - translate incorrect", result, ctest);
	}

	@Test
	public void circleGetBoundingRectangle() {
		assertSame("failure - rectable bounding circle incorrect", "The bounding rectangle is centered at " + "(5.0, 5.0)" 
        + " and has a height and width of" + 10.0 + " and " + 10.0 + " respectively.", c1.getBoundingRectangle());
	}

	@Test
	public void squareContainsPoint() {
		assertTrue("failure - containsPoint incorrect", s1.containsPoint(p1));
	}

	@Test (expected = IllegalArgumentException.class)
	public void negativeSquareSide() {
		Square test = new Square(-5.0);
	}

	@Test
	public void squareGetBoundingRectangle() {
		assertSame("failure - rectangle bounding square incorrect", "The bounding rectangle is cornered at " + "(0.0, 0.0)" 
        + " and has a height and width of" + 5.0 + " and " + 5.0 + " respectively.", s1.getBoundingRectangle());	
	}

	@Test
	public void squareTranslateTest() {
		Point ptest = new Point(1.0,1.0);
		Square stest = s1.translate(ptest);
		String result = "Square bound by: (1, 1) (1, 6) (6, 6), and  (6, 1)";
		assertEquals("failure - translate incorrect", result, stest);
	}

	@Test 
	public void rectangleContainsPoint() {
		assertTrue("failure - containsPoint incorrect", r1.containsPoint(p2));
	}

	@Test
	public void rectangleGetBoundingRectangle() {
		assertSame("failure - rectangle bounding rectangle incorrect", "The bounding rectangle is cornered at " + "(0.0, 0.0)" 
        + " and has a height and width of" + 10.0 + " and " + 5.0 + " respectively.", r1.getBoundingRectangle());	
	}

	@Test (expected = IllegalArgumentException.class)
	public void negativeRectangleSide() {
		Rectangle test = new Rectangle(-3.0, 10.0);
	}

	@Test
	public void rectangleTranslateTest() {
		Point ptest = new Point(1.0,1.0);
		Rectangle rtest = r1.translate(ptest);
		String result = "Rectangle bound by: (1, 1) (1, 11) (6, 11), and  (6, 1)";
		assertEquals("failure - translate incorrect", result, rtest);
	}

	@Test 
	public void rightTriangleContainsPoint() {
		assertTrue("failure - containsPoint incorrect", rt1.containsPoint(p1));
	}

	@Test
	public void triangleGetBoundingRectangle() {
		assertSame("failure - rectangle bounding triangle incorrect", "The bounding rectangle is cornered at " + "(0.0, 0.0)" 
        + " and has a height and width of" + 10.0 + " and " + 10.0 + " respectively.", r1.getBoundingRectangle());	
	}

	@Test (expected = IllegalArgumentException.class)
	public void negativeRightTriangleSide() {
		RightTriangle test = new RightTriangle(-2.0, 5.0);
	}

	@Test
	public void triangleTranslateTest() {
		Point ptest = new Point(1.0,1.0);
		RightTriangle ttest = rt1.translate(ptest);
		String result = "Triangle bound by (1.0, 1.0) (1.0, 11.0) (11.0, 1.0).";
		assertEquals("failure - translate incorrect", result, ttest);
	}

}