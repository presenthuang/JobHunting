package leetcode.stackQueue;
import java.util.Stack;

class MinStack extends Stack<Integer>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer> minimum = new Stack<Integer>();
    public void push(int x) {
        if(x <= getMin()){
            minimum.push(x);
        }
        super.push(x);
    }

    public Integer pop() {
        if(super.isEmpty())
            return 0;
        int cur = super.pop();
        if(cur == minimum.peek()){
            minimum.pop();
        }
        return 0;
    }

    public int top() {
        if(super.isEmpty()){
            return 0;
        }
        return super.peek();
    }

    public int getMin() {
        if(minimum.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minimum.peek();
    }
}