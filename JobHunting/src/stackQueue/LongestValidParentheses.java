package stackQueue;

import java.util.Stack;

public class LongestValidParentheses {
//	Given a string containing just the characters 
//	'(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//	For "(()", the longest valid parentheses 
//	substring is "()", which has length = 2.
//
//	Another example is ")()())", where the longest valid 
//	parentheses substring is "()()", which has length = 4.
	
//	http://codeganker.blogspot.com/2014/03/longest-valid-parentheses-leetcode.html
	
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int total = 0;
        int start = 0;
        for(int i = 0; i < length; ++i){
        	char current = s.charAt(i);
        	if(current == '('){
        		stack.push(i);
        	}else {
				if(stack.isEmpty()){
					start = i+1;
				}else {
					stack.pop();
					total = stack.isEmpty()?Math.max(total, i-start+1):Math.max(total, i-stack.peek());
				}
			}
        }
        return total;
    }
}
