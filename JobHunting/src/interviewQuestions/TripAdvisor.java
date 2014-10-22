package interviewQuestions;

public class TripAdvisor {
	// you can also use imports, for example:
	// import java.util.*;

	// you can use System.out.println for debugging purposes, e.g.
	// System.out.println("this is a debug message");
	class Tree{
		int val;
		Tree l;
		Tree r;
	}
	
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T == null){//if the node is null, this is edge case, then we would return -1
            return -1;    
        }
        return Math.max(helper(T.l, true, 1), helper(T.r, false, 1));
    }
    
    /**
     * isLeft is true, it would return from left child, isLeft is false, it would from right child.
     **/
    public int helper(Tree root, boolean isLeft, int depth){
        if(root == null){//if current node is null, then we need to return current depth -1
            return depth-1;
        }
        //maximal depth for left child
        int leftResult = helper(root.l, true, isLeft?depth+1:1);
        //maximal depth from right child
        int rightResult = helper(root.r, false, isLeft?1:depth+1);
        //return the maximal from left or right.
        return Math.max(leftResult,rightResult);
    }
}
