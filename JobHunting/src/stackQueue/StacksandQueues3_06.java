package stackQueue;

import java.util.Stack;


public class StacksandQueues3_06 {
//Write a program to sort a stack in ascending order (with biggest items on top).
//You may use at most one additional stack to hold items, but you may not copy the
//elements into any other data structure (such as an array). The stack supports the
//following operations: push, pop, peek, and isEmpty.
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> helper = new Stack<>();
		
		if(s.size() <= 1)
			 return s;
		helper.push(s.pop());
		while(!s.isEmpty()){
			int cur = s.pop();
			while(!helper.isEmpty() && cur < helper.peek()){
				s.push(helper.pop());
			}
			helper.push(cur);
		}
		return helper;
	}
}
