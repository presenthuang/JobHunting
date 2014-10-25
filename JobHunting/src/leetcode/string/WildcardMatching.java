package leetcode.string;

public class WildcardMatching {
//	Implement wildcard pattern matching with support for '?' and '*'.
//
//	'?' Matches any single character.
//	'*' Matches any sequence of characters (including the empty sequence).
//
//	The matching should cover the entire input string (not partial).
//
//	The function prototype should be:
//	bool isMatch(const char *s, const char *p)
//
//	Some examples:
//	isMatch("aa","a") → false
//	isMatch("aa","aa") → true
//	isMatch("aaa","aa") → false
//	isMatch("aa", "*") → true
//	isMatch("aa", "a*") → true
//	isMatch("ab", "?*") → true
//	isMatch("aab", "c*a*b") → false
	
	
	//time complexity(o(n^2))
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while(i < s.length()){
        	if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){//if current 2 chars are the same.
        		++j;
        		++i;
        	} else if(j < p.length() && p.charAt(j) == '*'){//if current char is a star, then just consume this char.
        		star = j++;
        		mark = i;
        	} else if (star != -1) {//this means that we have the star before hand and the next char in j is not match.
				j = star + 1;
				i = ++mark;
			} else{//no matching and no char here.
				return false;
			}
        }
        while(j < p.length() && p.charAt(j) == '*'){
        	++j;
        }
        return j == p.length();
    }
    public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("hh", "*h"));
	}
}
