package edu.columbia.xh2211.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
//	Given a collection of candidate numbers (C) and a target number (T), 
//	find all unique combinations in C where the candidate numbers sums to T.
//
//	Each number in C may only be used once in the combination.
//
//	Note:
//	All numbers (including target) will be positive integers.
//	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//	The solution set must not contain duplicate combinations.
//	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//	A solution set is: 
//	[1, 7] 
//	[1, 2, 5] 
//	[2, 6] 
//	[1, 1, 6]
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> intermediate = new ArrayList<Integer>();
        
        helper(num, result, intermediate, target, 0);
        return result;
    }

	private void helper(int[] num, List<List<Integer>> result, List<Integer> intermediate, int target, int start) {
		if(target == 0){
			List<Integer> temp = new ArrayList<Integer>(intermediate);
			result.add(temp);
			return;
		}
		
		for(int i = start; i < num.length; ++i){
			if(num[i] > target){
				continue;
			}
			intermediate.add(num[i]);
			helper(num,result,intermediate,target-num[i],i+1);
			intermediate.remove(intermediate.size()-1);
            while(i+1<num.length && num[i]==num[i+1]){
                i++;
            }
		}
	}
}
