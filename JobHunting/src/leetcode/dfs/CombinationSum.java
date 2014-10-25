package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
//	Given a set of candidate numbers (C) and a target number (T), 
//	find all unique combinations in C where the candidate numbers sums to T.
//
//	The same repeated number may be chosen from C unlimited number of times.
//
//	Note:
//	All numbers (including target) will be positive integers.
//	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//	The solution set must not contain duplicate combinations.
//	For example, given candidate set 2,3,6,7 and target 7, 
//	A solution set is: 
//	[7] 
//	[2, 2, 3] 
	
//	https://github.com/yuanx/leetcode/blob/master/CombinationSum.java
    
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		  if(candidates == null){
	            return null;
	        }
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> intermediate = new ArrayList<Integer>();
	        if(candidates.length == 0){
	            result.add(new ArrayList<Integer>());
	        	return result;
	        }
        int upper = candidates.length-1;
        while(upper >= 0){
        	if(candidates[upper] > target){
        		upper--;
        	}else{
        		break;
        	}
        }
        if(upper == -1)
        	return result;
        helper(candidates, result, intermediate, target, 0, upper);
        return result;
    }

	private void helper(int[] candidates, List<List<Integer>> result, List<Integer> intermediate, int target, int start, int end) {
		if(target < 0)
			return;
		if(target == 0){
			result.add(new ArrayList<Integer>(intermediate));
			return;
		}
		
		for(int i = start; i <= end; ++i){
			if(i > 0 && candidates[i] == candidates[i-1])
				continue;
			intermediate.add(candidates[i]);
			helper(candidates, result, intermediate, target - candidates[i], i, end);
			intermediate.remove(intermediate.size() - 1);
		}
	}
}
