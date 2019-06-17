import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author waser
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m;
		int n;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> terms = new ArrayList<String>();
		
		int choice;
		String input;
		boolean getMore = true;
		Scanner kb = new Scanner(System.in);

		System.out.println("What is your lower range number?");
		m = kb.nextInt();

		System.out.println("What is your upper range number?");
		n = kb.nextInt();

		System.out.println("What would you like to check the numbers are divisible by? I.e 2, 3, 5" +
							"\n" + "Type '-1' when you are done.");

		do
		{
			choice = kb.nextInt();
			if(choice != -1)
			{
				numbers.add(choice);
			}
			else
			{
				getMore = false;
			}
		}while(getMore == true);


		System.out.println("What would you like your divisible words to say?");
		for(Integer i: numbers)
		{
			System.out.println("What would you like " + i + " to say?");
			terms.add(kb.next());
			
		}
		
		//System.out.println(numbers);
		//System.out.println(terms);
		fizzBuzzAdvanced(m, n, numbers, terms);
	}
	
	public static void fizzBuzzAdvanced(int m, int n, ArrayList<Integer> numbers, ArrayList<String> terms)
	{
		while(m <= n)
		{
			String line = "";
			for(int index = 0; index < numbers.size(); index++)
			{
				if(m % numbers.get(index) == 0)
				{
					line+= terms.get(index);
				}
				else
				{
					line = Integer.toString(m);
				}
				System.out.println(line);
			}
			System.out.println();
			m++;
		}
	}

}
