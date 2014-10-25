package leetcode.stackQueue;

import java.util.Stack;

public class ValidParentheses {
//	Given a string containing just the characters 
//	'(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//	The brackets must close in the correct order, 
//	"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	
//	just use a stack and save different char in, there is only 6 kinds of parentheses
	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int length = s.length();
		for(int pos = 0; pos < length; ++pos){
			switch(s.charAt(pos)){
				case '{':
					stack.push(1);
					break;
				case '[':
					stack.push(2);
					break;
				case '(':
					stack.push(3);
					break;
				case '}':
					if(stack.isEmpty() || stack.pop() != 1)
						return false;
					break;
				case ']':
					if(stack.isEmpty() || stack.pop() != 2)
						return false;
					break;
				case ')':
					if(stack.isEmpty() || stack.pop() != 3)
						return false;
					break;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
    }
}
