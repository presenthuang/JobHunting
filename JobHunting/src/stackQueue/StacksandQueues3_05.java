package stackQueue;

import java.util.Stack;

public class StacksandQueues3_05 {
//Implement a MyQueue class which implements a queue using two stacks.
	
	public class MyQueue<T>{
		Stack<T> s1;
		Stack<T> s2;
		public MyQueue() {
			s1 = new Stack<T>();
			s2 = new Stack<T>();
		}
		
		public int size(){
			return s1.size() + s2.size();
		}
		
		public void add(T value){
			s1.push(value);
		}
		
		private void shiftStacks(){
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
		}
		
		public T peek(){
			shiftStacks();
			return s2.peek();
		}
		
		public T remove(){
			shiftStacks();
			return s2.pop();
		}
	}
}
