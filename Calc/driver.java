import java.util.*;

public class driver {



	public static void main (String[] args) {

		Double inputA = 0.0;
		Double inputB = 0.0;
		int menuSelection;
		Double answer;

		Scanner kb = new Scanner(System.in);
	System.out.println("what would you like to do ?" + "\n" + 
							" 1. Add" + "\n" +
							" 2. Subtract" + "\n" +
							" 3. Multiply" + "\n" +
							" 4. Divide");
	
		System.out.print("Please enter the basic operation you would liek to perform: ");
		menuSelection = kb.nextInt();

		do
		{
			try {
				System.out.println("What is your first number?");
				inputA = Double.parseDouble(kb.next());
				
				System.out.println("What is your second number?");
				inputB = Double.parseDouble(kb.next());
			}
			catch(NumberFormatException e)
			{
				
			}
		}while(!isValid(inputA) && !isValid(inputB));
		
		Calculator c = new Calculator();

		answer = c.doMath(menuSelection, inputA, inputB);

		System.out.println("Your answer is: " + answer);



	}
	
	private static boolean isValid(Double room){
		   if(room > 4 || room  < 1){
		       System.out.println("Try again ;)" );
		       return false;
		   }  else return true;
		}
}