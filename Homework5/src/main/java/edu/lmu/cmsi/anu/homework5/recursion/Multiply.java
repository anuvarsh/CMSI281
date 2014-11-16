package edu.lmu.cmsi.anu.homework5.recursion;

public class Multiply {
	//multiplies x and y so long as they are definied and > 0
	public static int mult(int x, int y) {
		int result;
		if (y == 1) {
			result = x;
		} else {
			result = x + mult(x, y-1);
		}
		return result;
	}
}