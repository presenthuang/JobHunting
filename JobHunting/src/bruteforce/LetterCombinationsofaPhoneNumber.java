package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
//	Given a digit string, return all possible letter combinations that the number could represent.
//
//	Input:Digit string "23"
//	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//	Note:
//	Although the above answer is in lexicographical order, your answer could be in any order you want.
    public List<String> letterCombinations(String digits) {
    	String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
    	List<String> ret = new ArrayList<String>();  
        rec(ret, digits.length(), ss, digits, new StringBuffer());  
        return ret;  
    }

	private void rec(List<String> ret, int remain, String[] ss, String digits, StringBuffer sb) {
		if(remain == 0){
			ret.add(sb.toString());
			return;
		}
		String s = ss[digits.charAt(0)-'0'];
		for(int i = 0; i < s.length(); ++i){
			sb.append(s.charAt(i));
			rec(ret,remain-1,ss,digits.substring(1),sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
