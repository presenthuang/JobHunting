package string;

public class LongestPalindromicSubstring {
//	Given a string S, find the longest palindromic substring in S. 
//	You may assume that the maximum length of S is 1000, 
//	and there exists one unique longest palindromic substring.
	
//	http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
	
    public String longestPalindrome(String s) {
        if(s == null)
        	return s;
    	int length = s.length();
        if(length < 2)
        	return s;
        String longest = s.substring(0,1);
        for(int i = 0; i < length; ++i){
        	String temp = helper(s, i, i);
        	if(temp.length() > longest.length()){
        		longest = temp;
        	}
        	temp = helper(s, i, i+1);
        	if(temp.length() > longest.length()){
        		longest = temp;
        	}
        }
        return longest;
    }

	private String helper(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin)==s.charAt(end)){
			begin--;
			end++;
		}
		return s.substring(begin+1,end);
	}
    
}
