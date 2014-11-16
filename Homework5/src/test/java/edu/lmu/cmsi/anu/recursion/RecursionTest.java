package edu.lmu.cmsi.anu.recursion;

import edu.lmu.cmsi.anu.recursion.Fibonacci;

import org.junit.*;
import static org.junit.Assert.*;


public class RecursionTest {

    @Test
    public void fibTest() {
    	assertEquals("did not run fibAtIndex correctly", 3, Fibonacci.fibAtIndex(5));
    }
}