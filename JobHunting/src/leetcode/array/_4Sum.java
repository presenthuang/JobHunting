package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _4Sum {
// ==================================================================  //  
//	4Sum
//Given an array S of n integers, 
//are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
//For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//A solution set is:
//(-1,  0, 0, 1)
//(-2, -1, 1, 2)
//(-2,  0, 0, 2)
//==================================================================  //  

//http://www.programcreek.com/2013/02/leetcode-4sum-java/
	
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<List<Integer>> hashset = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length; ++i){
        	for(int j = i+1; j < num.length; ++j){
        		int k = j + 1;
        		int l = num.length - 1;
        		while(k < l){
        			int sum = num[i] + num[j] + num[k] + num[l];
        			if(sum > target){
        				l--;
        			}else if(sum < target){
        				k++;
        			}else if(sum == target){
        				List<Integer> temp = new ArrayList<Integer>();
        				temp.add(num[i]);
        				temp.add(num[j]);
        				temp.add(num[k]);
        				temp.add(num[l]);
        				
        				if(!hashset.contains(temp)){
        					result.add(temp);
        					hashset.add(temp);
        				}
        				k++;
        				l--;
        			}
        		}
        	}
        }
        return result;
    }
}
