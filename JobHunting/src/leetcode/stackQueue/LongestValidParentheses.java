package leetcode.stackQueue;

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
	
//	use stack
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int total = 0;
        int start = 0;
        for(int i = 0; i < length; ++i){
        	char current = s.charAt(i);
        	if(current == '('){//if the parenthese is left, push the index of it.
        		stack.push(i);
        	}else {//if the parenthese is right
				if(stack.isEmpty()){//if the stack is empty, invalid, start move forward.
					start = i+1;
				}else {//pop the current number, which indicate the stack's last left parenthese
					stack.pop();
					total = stack.isEmpty()?Math.max(total, i-start+1):Math.max(total, i-stack.peek());
				}
			}
        }
        return total;
    }
    
    public static void main(String[] args) {
		LongestValidParentheses lig = new LongestValidParentheses();
		System.out.println(lig.longestValidParentheses("()))()())"));
	}
}
