package string;

public class StringtoInteger_atoi_ {
//	Implement atoi to convert a string to an integer.
//
//	Hint: Carefully consider all possible input cases. 
//	If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//	Notes: It is intended for this problem to be specified vaguely 
//	(ie, no given input specs). You are responsible to gather all the input requirements up front.
	
    public int atoi(String str) {
    	long result = 0;
    	boolean flag = false;
    	if(str == null || str.length() == 0)
    		return (int)result;
    	int length = str.length();
    	int start = 0;
    	while(str.charAt(start) == ' '){//if the previous is not a integer.
    		start++;
    	}
    	if(str.charAt(start) == '-'){//if the integer is negative
    		flag = true;
    		start++;
    	}else if(str.charAt(start) == '+'){
    	    start++;
    	}
    	for(int i = start; i < length; ++i){
    		if(result >= Integer.MAX_VALUE){//if the result is greater than the scope of Integer
    			break;
    		}
    		int digit = str.charAt(i)-'0';
    		if(digit > 9 || digit < 0)//if the digit is not belongs to an digit
    			break;
    		result = result * 10 + digit;
    	}
    	return flag? -(int)result:(int)result;
    }
    
}
