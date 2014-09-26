package interviewQuestions;

import java.util.List;

public class LinkedIn_NestedInteger {
	public int depthSum (List<NestedInteger> input)
	{
		if(input == null)
			return 0;
		return helper(input, 1);
	}
	
	private int helper(List<NestedInteger> input, int currdepth) {
		int total = 0;
		for(int i = 0; i < input.size(); ++i){
			if(input.get(i).isInteger()){
				total += currdepth * input.get(i).getInteger();
			}else{
				total += helper(input.get(i).getList(), currdepth+1);
			}
		}
		return total;
	}

	/**
	 * This is the interface that allows for creating nested lists. 
	 * You should not implement it, or speculate about its implementation
	 */
	public interface NestedInteger 
	{
	    // Returns true if this NestedInteger holds a single integer, rather than a nested list
	    public boolean isInteger();

	    // Returns the single integer that this NestedInteger holds, if it holds a single integer
	    // Returns null if this NestedInteger holds a nested list
	    public Integer getInteger();

	    // Returns the nested list that this NestedInteger holds, if it holds a nested list
	    // Returns null if this NestedInteger holds a single integer
	    public List<NestedInteger> getList();
	}   
}
