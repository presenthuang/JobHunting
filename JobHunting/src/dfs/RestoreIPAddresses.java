package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
//	Given a string containing only digits, 
//	restore it by returning all possible valid IP address combinations.
//
//	For example:
//	Given "25525511135",
//
//	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	
    public List<String> restoreIpAddresses(String s) {
    	List<String> results = new ArrayList<String>();
    	if(s==null || s.length()==0)  
            return results; 
    	helper(results, "", s, 0, 1);
    	
    	return results;
    }

	private void helper(List<String> results, String parts, String s, int start, int segment) {
		if(start >= s.length())
			return;
		if(segment == 4){
			String str = s.substring(start);
			if(isValid(str)){
				results.add(parts + "."+str);
			}
			return;
		}
		
		for(int i = 1; i < 4&&(i+start <= s.length()); ++i){
			String num = s.substring(start, start+i);
			if(!isValid(num))
				continue;
			if(segment == 1){
				helper(results, num, s, start+i, segment+1);
			}else{
				helper(results, parts+"."+num, s, start+i, segment+1);
			}
		}
	}

	private boolean isValid(String str) {
		if(str==null || str.length()>3)  
			 return false;  
		int num = Integer.parseInt(str);  
		if(str.charAt(0)=='0' && str.length()>1)  
			return false;  
		if(num>=0 && num<=255)  
			return true;  
		return false;  
	}
}
