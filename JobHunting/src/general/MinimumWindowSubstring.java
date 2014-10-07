package general;

import java.util.HashMap;

public class MinimumWindowSubstring {
//	Given a string S and a string T, 
//	find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//	For example,
//	S = "ADOBECODEBANC"
//	T = "ABC"
//	Minimum window is "BANC".
//
//	Note:
//	If there is no such window in S that covers all characters in T, return the emtpy string "".
//
//	If there are multiple such windows, 
//	you are guaranteed that there will always be only one unique minimum window in S.
	
//	http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
//!!!!!	
//	The main idea is to maintain two pointers which are called begin and end, 
//	then use two HashMap to record current status, one record what char need to find, 
//	another used to record what has found.
//	if the two HashMaps show current substring of S has contain all of the chars in T, 
//	then we try to shrink our start and end pointer 
	
    public String minWindow(String S, String T) {
    	if(S == null || T == null)
    		return null;
    	HashMap<Character, Integer>need=new HashMap<Character, Integer>();
        HashMap<Character, Integer>already=new HashMap<Character, Integer>();

        for(int i=0; i<T.length(); i++){//this for loop will iterate all chars in T and save them to needFind.
            already.put(T.charAt(i), 0);
            if (need.containsKey(T.charAt(i)))
                need.put(T.charAt(i), need.get(T.charAt(i))+1);
            else
                need.put(T.charAt(i), 1);
        }
        
        int minStart=-1;
        int minEnd=S.length();
        int start=0;
        int len=0;
        for (int i=0; i<S.length(); i++){//iterate all the string values in the S string and find out the least length
            if (already.containsKey(S.charAt(i))){
                already.put(S.charAt(i), already.get(S.charAt(i))+1);
                if (already.get(S.charAt(i))<=need.get(S.charAt(i)))
                    len++;
                if (len==T.length()){
                    while (!need.containsKey(S.charAt(start))
                    		|| already.get(S.charAt(start))>need.get(S.charAt(start))){
                        if (need.containsKey(S.charAt(start)))
                            already.put(S.charAt(start), already.get(S.charAt(start))-1);
                        start++;
                    }
                    if (i-start<minEnd-minStart){
                        minStart=start;
                        minEnd=i;
                    }
                }
            }
        }
        if (minStart==-1)
            return "";
        return S.substring(minStart, minEnd+1);
    }
    
    public static void main(String[] args) {
		MinimumWindowSubstring ms = new MinimumWindowSubstring();
		System.out.println(ms.minWindow("abc", "ac"));
	}
}
