package interviewQuestions;

public class StringToLong {
//	Given a string, write a routine that converts the string to a long, without using the built in functions that would do this. Describe what (if any) limitations the code has. For example:
//		long stringToLong(String s)
//		{
//		    /* code goes here to convert a string to a long */
//		}
//		void test() {
//		    long i = stringToLong("123");
//		    if (i == 123)
//		        // success
//		    else
//		// failure
//		}
	private long stringToLong(String s){
		long result = 0;
		boolean neg = false;
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			if(c == '-'){
				neg = !neg;
				continue;
			}
			int val = c - '0';
			if(val < 0 || val > 9){
				return -1;
			}
			result = result * 10 + val;
		}
		return neg?-result:result;
	}
	
	void test() {
	    long i = stringToLong("123");
	    if (i == 123){
	        // success
	    }
	    else{
	    	// failure	    	
	    }
	}
//	The limitation of this code would be that the size of the number is limited, we cannot exceed the length of long.  
}
