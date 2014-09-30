package cc150.Question03;

import java.util.Stack;

public class StacksandQueues3_02 {
//	How would you design a stack which, in addition to push and pop, also has a 
//	function min which returns the minimum element? Push, pop and min should all 
//	operate in O(1) time.
	
	//Design problem
	@SuppressWarnings("serial")
	public class StackWithMin extends Stack<Integer>{
		Stack<Integer> s2;
		public StackWithMin(){
			s2 = new Stack<Integer>();
		}
		
		public void push(int value){
			if(value <= min()){
				s2.push(value);
			}
			super.push(value);
		}
		
		public Integer pop(){
			int value = super.pop();
			if(value == min()){
				s2.pop();
			}
			return value;
		}
		
		public int min(){
			if(s2.isEmpty()){
				return Integer.MAX_VALUE;
			}
			return s2.peek();
		}
	}
}
