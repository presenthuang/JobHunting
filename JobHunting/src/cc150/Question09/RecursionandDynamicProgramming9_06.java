package cc150.Question09;

import java.util.HashSet;
import java.util.Set;

public class RecursionandDynamicProgramming9_06 {
//Implement an algorithm to print all valid (i.e. properly opened and closed) combinations
//of n-pairs of parentheses
	public static Set<String> generateParens(int remaining){
		Set<String> results = new HashSet<String>();
		if(remaining <= 0)
			return results;
		helper(results, new StringBuilder(""), 0, remaining, 0, 0);
		return results;
	}

	private static void helper(Set<String> results, StringBuilder current, int deep, int remaining, int left, int right) {
		if(deep == remaining * 2){
			results.add(new String(current));
			return;
		}
		if(left < remaining){
			current.append("(");
			helper(results,current,deep+1,remaining,left+1,right);
			current.deleteCharAt(current.length() - 1);
		}
		if(right < left){
			current.append(")");
			helper(results,current,deep+1,remaining,left,right+1);
			current.deleteCharAt(current.length() - 1);
		}
	}
	
	public static void main(String[] args){
		Set<String> result = RecursionandDynamicProgramming9_06.generateParens(3);
		for(String str : result){
			System.out.println(str);
		}
	}
}
