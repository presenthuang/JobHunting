package edu.columbia.xh2211.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
//	Given a string s, partition s such that every substring of the partition is a palindrome.
//
//	Return all possible palindrome partitioning of s.
//
//	For example, given s = "aab",
//	Return
//
//	  [
//	    ["aa","b"],
//	    ["a","a","b"]
//	  ]
	
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
    		return result;
    	}
        helper(result,new ArrayList<String>(), s, 0);
        return result;
    }

	private void helper(ArrayList<List<String>> result, ArrayList<String> onePart, String s, int start) {
		if(start == s.length()){
			result.add(new ArrayList<>(onePart));
		}
		
		for(int i = start+1; i <= s.length(); ++i){
			String current = s.substring(start,i);
			if(isPali(current)){
				onePart.add(current);
				helper(result, onePart, s, i);
				onePart.remove(onePart.size()-1);
			}
		}
	}

	private boolean isPali(String current) {
		int left = 0;
		int right = current.length()-1;
		
		while(left < right){
			if(current.charAt(left) != current.charAt(right))
				return false;
			else{
				left++;
				right--;
			}
		}
		
		return true;
	}
}
