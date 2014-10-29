package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
//	Given an array of strings, return all groups of strings that are anagrams.
//
//			Note: All inputs will be in lower-case.
	
//	Use a hashtable to store the information about the strings that are anagrams.
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> stored = new HashMap<>();
        List<String> result = new ArrayList<String>();
        for(String cur : strs){
        	String key = sortStr(cur);
        	if(stored.containsKey(key)){
        		ArrayList<String> same = stored.get(key);
        		same.add(cur);
        		stored.put(key, same);
        	}else{
        		ArrayList<String> same = new ArrayList<String>();
        		same.add(cur);
        		stored.put(key, same);
        	}
        }
        for(String key : stored.keySet()){
        	ArrayList<String> list = stored.get(key);
        	if(list.size() > 1){
        		result.addAll(list);
        	}
        }
        return result;
    }

	private String sortStr(String cur) {
		char [] array = cur.toCharArray();
		Arrays.sort(array);
		String result = new String(array);
		return result;
	}
}
