package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
//	You are given a string, S, 
//	and a list of words, L, 
//	that are all of the same length. 
//	Find all starting indices of substring(s) in S 
//	that is a concatenation of each word in L exactly once and without any intervening characters.
//
//	For example, given:
//	S: "barfoothefoobarman"
//	L: ["foo", "bar"]
//
//	You should return the indices: [0,9].
//	(order does not matter).
	
//	source: https://github.com/rffffffff007/leetcode/blob/master/Substring%20with%20Concatenation%20of%20All%20Words.java
	
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> subPos = new ArrayList<Integer>();
        if (S == null || S.length()  == 0 || L == null || L.length == 0)
            return subPos;
        int lens = S.length();
        int lenl = L.length;
        int wordLen = L[0].length();
        int totalLen = wordLen * lenl;
        Map<String, Integer> lMap = new HashMap<String, Integer>();
        Map<String, Integer> sMap = new HashMap<String, Integer>();
        for (String l : L)
            addMap(lMap, l);
        for (int i = 0; i <= lens - totalLen; i++) {
            sMap.clear();
            int j = i;
            for (; j < i + totalLen; j += wordLen) {
                String sub = S.substring(j, j + wordLen);
                if (lMap.containsKey(sub)) {
                    addMap(sMap, sub);
                    if (sMap.get(sub) > lMap.get(sub))
                        break;
                } else 
                    break;
            }
            if (j == i + totalLen) 
                subPos.add(i);
        }
        return subPos;
    }

    private void addMap(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) 
            map.put(key, map.get(key) + 1);
        else 
            map.put(key, 1);
    }
}
