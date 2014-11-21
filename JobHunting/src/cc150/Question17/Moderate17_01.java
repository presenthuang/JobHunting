package cc150.Question17;

public class Moderate17_01 {
//Write a function to swap a number in place (that is, without temporary variables).
	
	public void SwapNumberInplace(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("a: " + a + ", b: " + b);
	}
	public static void main(String[] args) {
		new Moderate17_01().SwapNumberInplace(-40, 15);
	}
}
