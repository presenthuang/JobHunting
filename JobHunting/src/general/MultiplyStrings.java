package general;

public class MultiplyStrings {
//	Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//	Note: The numbers can be arbitrarily large and are non-negative.
	
//	we could use the arraylist to store the multiple results.
    public String multiply(String num1, String num2) {
		StringBuffer numBuffer1 = new StringBuffer(num1).reverse();
		StringBuffer numBuffer2 = new StringBuffer(num2).reverse();
		
		// even 99 * 99 is < 10000, so maximaly 4 digits
		int [] results = new int[num1.length()+num2.length()];
		
		for(int i = 0; i < num1.length(); ++i){
			int a = numBuffer1.charAt(i) - '0';
			for(int j = 0; j < num2.length(); ++j){
				int b = numBuffer2.charAt(j) - '0';
				results[i+j] += a * b;
			}
		}
		
		StringBuffer resultBuffer = new StringBuffer();
		for(int i = 0; i < results.length; ++i){
			int digit = results[i] % 10;
			int carry = results[i] / 10;
			resultBuffer.append(digit);
			if(i<results.length-1)
				results[i+1] += carry;
		}
		resultBuffer.reverse();
		while(resultBuffer.length() > 0 && resultBuffer.charAt(0) == '0')
			resultBuffer.deleteCharAt(0);
		return resultBuffer.length() == 0 ? "0":resultBuffer.toString();
    }
}
