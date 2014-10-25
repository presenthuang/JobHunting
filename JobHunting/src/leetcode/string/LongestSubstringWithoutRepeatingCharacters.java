package leetcode.string;

public class LongestSubstringWithoutRepeatingCharacters {
//	Given a string, find the length of the longest substring without repeating characters. 
//	For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
//	which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
	
	
//	http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        boolean[] exist = new boolean[256];
        while(j < n){
        	//when we encounter with an existing character in current substring, first update maximal, 
//        	then find the appearance in substring and start from there.
        	if(exist[s.charAt(j)]){
        		maxLen = Math.max(maxLen, j-i);
        		while(s.charAt(i)!=s.charAt(j)){
        			exist[s.charAt(i)] = false;
        			i++;
        		}
        		i++;
        		j++;
        	}else {
				exist[s.charAt(j)] = true;
				j++;
			}
        }
        maxLen = Math.max(maxLen, n-i);
        return maxLen;
    }
}
