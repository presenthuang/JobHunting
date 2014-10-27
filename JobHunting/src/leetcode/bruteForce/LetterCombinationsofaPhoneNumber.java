package leetcode.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
//	Given a digit string, return all possible letter combinations that the number could represent.
//
//			A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//			Input:Digit string "23"
//			Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//			Note:
//			Although the above answer is in lexicographical order, your answer could be in any order you want.
	
//	be careful with the border cases.
    public List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = new ArrayList<>();
        if(digits == null){
        	return result;
        }
        if(digits.length() == 0){
            result.add("");
            return result;
        }
        int[]nums = new int[digits.length()];
        for(int i = 0; i < digits.length(); ++i){
        	nums[i] = digits.charAt(i) - '0';
        }
        helper(result,table,nums,0, new StringBuilder(""));
        return result;
    }

	private void helper(ArrayList<String> result, String[] table, int[] nums,int depth, StringBuilder current) {
		if(depth == nums.length){
			result.add(new String(current));
			return;
		}
		String candidates = table[nums[depth]];//get the candidates of the string.
		for(int i = 0; i < candidates.length(); ++i){
			current.append(candidates.charAt(i));
			helper(result, table, nums, depth+1, current);
			current.deleteCharAt(current.length()-1);
		}
	}
    
    
}
