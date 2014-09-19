package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
// ==================================================================  // 
//  Word Break II 
//  Given a string s and a dictionary of words dict, 
//  add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//  Return all such possible sentences.
//
//  For example, given
//  s = "catsanddog",
//  dict = ["cat", "cats", "and", "sand", "dog"].
//
//  A solution is ["cats and dog", "cat sand dog"].
//==================================================================  //
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new ArrayList<String>();
        if(s == null || s.length() == 0)
        	return ret;
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; ++i){
        	if(dict.contains(s.substring(0,i))){
        		dp[i] = true;
        		continue;
        	}
        	for(int j = 0; j < i; ++j){
        		if(dp[j] && dict.contains(s.substring(j,i))){
        			dp[i] = true;
        			continue;
        		}
        	}
        }
        if(dp[n] == false) return ret;
        StringBuffer sb = new StringBuffer();
        dfs(s,0,sb,ret,dict);
        return ret;
    }
    public void dfs(String s, int index, StringBuffer sb, List<String> ret, Set<String> dict){
    	int n = s.length();
    	if(index >= n){
    		ret.add(new String(sb));
    		return;
    	}
    	
    	for(int i = index + 1; i <= n; ++i){
    		String sub = s.substring(index,i);
    		if(dict.contains(sub)){
    			int oldLen = sb.length();
    			if(oldLen != 0) sb.append(" ");
    			sb.append(sub);
    			dfs(s,i,sb,ret,dict);
    			sb.delete(oldLen, sb.length());
    		}
    	}
    }
}
