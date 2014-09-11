package edu.columbia.xh2211.leetcode;

public class CountandSay {

//	The count-and-say sequence is the sequence of integers beginning as follows:
//		1, 11, 21, 1211, 111221, ...
//
//		1 is read off as "one 1" or 11.
//		11 is read off as "two 1s" or 21.
//		21 is read off as "one 2, then one 1" or 1211.
//		Given an integer n, generate the nth sequence.
//
//		Note: The sequence of integers will be represented as a string.
	
//	http://rleetcode.blogspot.com/2014/02/count-and-say-java.html
	
    public String countAndSay(int n) {
        if(n < 1)
        	return null;
        int i = 2;
        String current = "1";
        while(i <= n){
        	current = say(current);
        	i++;
        }
        
        return current;
    }

	private String say(String current) {
		char last = current.charAt(0);
		String result = "";
		int i = 1;
		int count = 1;
		while(i < current.length()){
			if(current.charAt(i) == last){
				count++;
			}else{
				result += count;
				result += last;
				
				last = current.charAt(i);
				count = 1;
			}
			i++;
		}
		result += count;
		result += last;
		
		return result;
	}
    
    
}
