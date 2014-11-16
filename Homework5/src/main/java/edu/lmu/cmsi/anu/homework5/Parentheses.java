package edu.lmu.cmsi.anu.homework5;

import java.util.Stack;

public class Parentheses {
	private static Stack<Character> checkerStk = new Stack<Character>();

	public static boolean isBalanced(String expr) {
		int exprLen = expr.length();
		boolean res = true;

		for (int i = 0; i < exprLen; i++) {
			Character c = expr.charAt(i);
			if (c.equals('(') || c.equals('[')) {
				checkerStk.push(c);
			} else if (c.equals(')')) {
				Character cc = checkerStk.pop();
				if (!cc.equals('(')) { // mismatch
					res = false;
				}
			} else if (c.equals(']')) {
				Character cc = checkerStk.pop();
				if (!cc.equals('[')) { // mismatch
					res = false;
				}
			}
		}
		return res; 
	}
}