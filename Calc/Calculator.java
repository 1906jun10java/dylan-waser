public class Calculator
{
	public double doMath(int menuSelection, double inputA, double inputB)
	{
		double answer = 0;
		switch(menuSelection)
		{
			case 1:
				answer = inputA + inputB;
				break;

			case 2:
				answer = inputA - inputB;
				break;

			case 3:
				answer = inputA * inputB;
				break;

			case 4:
				answer = inputA / inputB;
		}
		return answer;

	}
}