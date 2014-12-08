package leetcode.string;

public class StringtoInteger_atoi_ {
//	Implement atoi to convert a string to an integer.
//
//	Hint: Carefully consider all possible input cases. 
//	If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//	Notes: It is intended for this problem to be specified vaguely 
//	(ie, no given input specs). You are responsible to gather all the input requirements up front.
	
	
//	Considering for the different situation: space/sign/exceed the maximum value of integer
    public int atoi(String str) {
    	int result = 0;
    	boolean neg = false;
    	if(str == null || str.length() == 0)
    		return result;
    	int length = str.length();
    	int start = 0;
    	while(str.charAt(start) == ' '){//if the head is not a integer.
    		start++;
    	}
    	if(str.charAt(start) == '-'){//if the integer is negative
    		neg = true;
    		start++;
    	}else if(str.charAt(start) == '+'){
    	    start++;
    	}
    	for(int i = start; i < length; ++i){
    		int digit = str.charAt(i)-'0';
    		if(digit > 9 || digit < 0)//if the digit is not belongs to an digit, just break and return current result.
    			break;
    		if(result > Integer.MAX_VALUE / 10 
    				|| (!neg && result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) 
    				|| (neg && result == Integer.MAX_VALUE / 10 && digit > -(Integer.MIN_VALUE % 10))){
    			if(neg){
    				return Integer.MIN_VALUE;
    			}else{
    				return Integer.MAX_VALUE;
    			}
    		}
    		result = result * 10 + digit;
    	}
    	return neg? -result:result;
    }
    public static void main(String[] args) {
		System.out.println(new StringtoInteger_atoi_().atoi("2147483648"));
	}
}
