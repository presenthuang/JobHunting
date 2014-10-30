package leetcode.string;

public class ReverseWordsinaString {
//	Given an input string, reverse the string word by word.
//
//	For example,
//	Given s = "the sky is blue",
//	return "blue is sky the".
//
//	click to show clarification.
//
//	Clarification:
//	What constitutes a word?
//	A sequence of non-space characters constitutes a word.
//	Could the input string contain leading or trailing spaces?
//	Yes. However, your reversed string should not contain leading or trailing spaces.
//	How about multiple spaces between two words?
//	Reduce them to a single space in the reversed string.
	public String reverseWords(String s) {
        int length = s.length();
        int j = length;
        StringBuilder sb = new StringBuilder("");
        for(int i = length - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                j = i;
            }else if(i == 0 || s.charAt(i-1) == ' '){
                if(sb.length() != 0){
                    sb.append(" ");
                } 
                sb.append(s.substring(i,j));
            }
        }
        return sb.toString();
    }
	
	
}
