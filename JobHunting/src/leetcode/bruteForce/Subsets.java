package leetcode.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
//	Given a set of distinct integers, S, return all possible subsets.
//
//			Note:
//			Elements in a subset must be in non-descending order.
//			The solution set must not contain duplicate subsets.
//			For example,
//			If S = [1,2,3], a solution is:
//
//			[
//			  [3],
//			  [1],
//			  [2],
//			  [1,2,3],
//			  [1,3],
//			  [2,3],
//			  [1,2],
//			  []
//			]
	
//	using a stack to store the information about push and pop for an element.
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null)
        	return result;
    	Arrays.sort(S);
    	LinkedList<Integer> pile = new LinkedList<Integer>();
        helper(S,0,result,pile);
        return result;
    }

	private void helper(int[] S, int cur, List<List<Integer>> result, LinkedList<Integer> pile) {
		if(cur == S.length){
			List<Integer> temp = new ArrayList<Integer>(pile);
			result.add(temp);
			return;
		}
		pile.push(S[cur]);
		helper(S,cur+1,result,pile);
		pile.pop();
		helper(S,cur+1,result,pile);
	}
    
    public static void main(String[] args) {
		int[] list = {1,2,3};
		List<List<Integer>> result = new Subsets().subsets(list);
//		for(List<Integer> l : result){
//			for(Integer i : l){
//				System.out.print(i);
//			}
//		}
	}
}
