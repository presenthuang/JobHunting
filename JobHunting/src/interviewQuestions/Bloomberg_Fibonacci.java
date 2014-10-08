package interviewQuestions;

public class Bloomberg_Fibonacci {
//	Given a number n, write a function that writes a Fibonacci sequence to number n.
	
	
	public static void fibonacci(int n) {
		int prevNumber = 0;
		int currentNumber = 1;
		while (currentNumber <= n) {
			System.out.println(prevNumber);
			int temp = currentNumber;
			currentNumber = currentNumber + prevNumber;
			prevNumber = temp;
		}
		System.out.println(prevNumber);
	}
}
