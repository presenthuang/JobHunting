package edu.columbia.xh2211.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
//	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//	For example, given n = 3, a solution set is:
//
//	"((()))", "(()())", "(())()", "()(())", "()()()"
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n!=0){
        	helper(result,"",0,n,0,0);
        }
        return result;
    }

	private void helper(List<String> result, String current, int deep, int n, int left, int right) {
		if(deep == n * 2){
			result.add(current);
			return;
		}
		if(left < n){
			current += "(";
			helper(result,current,deep+1,n,left+1,right);
			current = current.substring(0,current.length() - 1);
		}
		if(right < left){
			current += ")";
			helper(result,current,deep+1,n,left,right+1);
			current = current.substring(0,current.length()-1);
		}
	}
}
