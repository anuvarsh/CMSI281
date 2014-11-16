import edu.lmu.cmsi.anu.homework5.recursion.Fibonacci;
import edu.lmu.cmsi.anu.homework5.recursion.Multiply;
import edu.lmu.cmsi.anu.homework5.recursion.StringToInt;
import edu.lmu.cmsi.anu.homework5.Parentheses;

public class App {
	public static void main(String [] args) {
		// fibonacci tests - 0 1 1 2 3 5 8...
		System.out.println("Fibonacci Tests");
		System.out.println(Fibonacci.fibAtIndex(0));
		System.out.println(Fibonacci.fibAtIndex(3));
		System.out.println();
		// multiply tests
		System.out.println("Multiply Tests");
		System.out.println(Multiply.mult(2,3));
		System.out.println(Multiply.mult(4,3));
		System.out.println();
		// string to int tests
		System.out.println("String to Int Tests");
		System.out.println(StringToInt.stringToInt("123"));
		System.out.println(StringToInt.stringToInt("234"));
		System.out.println();
		// balanced parentheses tests
		System.out.println("Balanced Parentheses Tests");
		System.out.println(Parentheses.isBalanced("(()[])"));
		System.out.println(Parentheses.isBalanced("[(])"));
		System.out.println();
	}
}