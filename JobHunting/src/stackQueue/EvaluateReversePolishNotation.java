package stackQueue;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
//	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//	Some examples:
//	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int length = tokens.length;
        for(int i = 0; i < length; ++i){
            String cur = tokens[i];
            if(cur.equals("+") && stack.size() >= 2){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first+second);
            }else if(cur.equals("-") && stack.size() >= 2){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first-second);
            }else if(cur.equals("*") && stack.size() >= 2){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first*second);
            }else if(cur.equals("/") && stack.size() >= 2){
                int divisor = stack.pop();
                int dividend = stack.pop();
                if(divisor == 0){
                    stack.push(Integer.MAX_VALUE);
                }else{
                    stack.push(dividend/divisor);
                }
            }else{
                try{
                    int number = Integer.parseInt(cur);
                    stack.push(number);
                }catch(Exception e){
                    System.err.println("Error Number format");
                }
            }
        }
        return stack.isEmpty()?0:stack.pop();
    }
}
