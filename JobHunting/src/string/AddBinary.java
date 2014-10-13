package string;

public class AddBinary {
	// ================================================================== //
	// Add Binary
	// Given two binary strings, return their sum (also a binary string).
	//
	// For example,
	// a = "11"
	// b = "1"
	// Return "100".
	// ================================================================== //
	
//	I think we should use stringbuilder to store the result and calculate the information
	public String addBinary(String a, String b) {
		int lengtha = a.length();
		int lengthb = b.length();
		boolean flag = false;
		String result = "";
		if (lengtha > lengthb) {
			while (lengtha > lengthb) {
				b = "0" + b;
				lengthb++;
			}
		} else {
			while (lengthb > lengtha) {
				a = "0" + a;
				lengtha++;
			}
		}
		int index = lengtha - 1;
		while (index > -1) {
			int total = Integer.parseInt(a.substring(index, index + 1))
					+ Integer.parseInt(b.substring(index, index + 1));
			if (flag)
				total++;
			switch (total) {
			case 0:
				result = "0" + result;
				flag = false;
				break;
			case 1:
				result = "1" + result;
				flag = false;
				break;
			case 2:
				result = "0" + result;
				flag = true;
				break;
			case 3:
				result = "1" + result;
				flag = true;
				break;
			}
			index--;
		}
		if (flag) {
			result = "1" + result;
		}
		return result;
	}
}
