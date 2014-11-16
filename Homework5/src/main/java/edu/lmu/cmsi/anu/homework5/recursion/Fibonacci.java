package edu.lmu.cmsi.anu.homework5.recursion;

public class Fibonacci {

    public static int fibAtIndex(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
        	return fibAtIndex(n-1) + fibAtIndex(n-2);
        }
    }
}