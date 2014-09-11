package edu.columbia.xh2211.leetcode;

public class Test {

	public static void main(String arg[]) {
		int a = 7;
		int b = 5;

		int prod = 0;
		
		while (b > 0) {
			int count = 0;
			int temp = b;
			while (temp / 2 > 0) {
				temp /= 2;
				count++;
			}
			prod += a << (count);
			b -= (1 << count);
		}
		
		System.out.println(prod);
	}
}
