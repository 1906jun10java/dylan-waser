import java.util.*;

public class driver {



	public static void main (String[] args) {

		double inputA;
		double inputB;
		int menuSelection = 0;
		double answer;

		Scanner kb = new Scanner(System.in);

		System.out.println("what would you like to do ?" + "\n" + 
							" 1. Add" + "\n" +
							" 2. Subtract" + "\n" +
							" 3. Multiply" + "\n" +
							" 4. Divide");
		menuSelection = kb.nextInt();

		System.out.println("What is your first number?");
		inputA = kb.nextDouble();

		System.out.println("What is your second number?");
		inputB = kb.nextDouble();

		Calculator c = new Calculator();

		answer = c.doMath(menuSelection, inputA, inputB);

		System.out.println("Your answer is: " + answer);



	}
}