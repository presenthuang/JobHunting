package string;

public class RegularExpressionMatching {
//	Implement regular expression matching with support for '.' and '*'.
//
//	'.' Matches any single character.
//	'*' Matches zero or more of the preceding element.
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
//	isMatch("aa", "a*") → true
//	isMatch("aa", ".*") → true
//	isMatch("ab", ".*") → true
//	isMatch("aab", "c*a*b") → true
	
    public boolean isMatch(String s, String p) {
        char[] as = s.toCharArray();
        char[] bs = p.toCharArray();
        for(int i = 0; i < bs.length; ++i){//here we will check that if all the letters in pattern would exist in the string.
        	if(Character.isLetter(bs[i]) && !isStarLetter(bs,i)){
        		boolean contains = false;
        		for(int j = 0; j < as.length; j++){
        			if(bs[i] == as[j]){
        				contains = true;
        				break;
        			}
        		}
        		if(!contains)
        			return false;
        	}
        }
        return match(s.toCharArray(),0,p.toCharArray(),0);//real processing.
    }

	private boolean match(char[] as, int ai, char[] bs, int bi) {
		int an = as.length;
		int bn = bs.length;
		if( (bn - bi) * (an - ai) == 0){//this means either a or b is empty now.
			while(bi < bn && isStarLetter(bs, bi)){
                bi += 2;
            }
            return bn - bi + an - ai == 0;
		}
		if (as[ai] == bs[bi] || bs[bi] == '.'){
            if (isStarLetter(bs, bi)) {//if b is star
                return match(as, ai + 1, bs, bi)//move a for 1 and b the same. //Check if there is another same char in a
                		|| match(as, ai + 1, bs, bi + 2) //move a for 1, b for 2. //Check if there is only one same char for this in a.
                		|| match(as, ai, bs, bi + 2);//move a the same, b for 2. //Check if there is no same char for this in a.
            }else {
                return match(as, ai + 1, bs, bi + 1);//move both a and b because they are the same.
            }
       } else {
           if (isStarLetter(bs, bi)) {//if not match, then move b with 2.
               return match(as, ai, bs, bi + 2);
           } else{//if not match and is not a star, then no way would be the same.
               return false;
           }
       }
	}

	private boolean isStarLetter(char[] bs, int i) {
		return i + 1 < bs.length && bs[i+1] == '*';
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching reg = new RegularExpressionMatching();
		System.out.println(reg.isMatch("aa", "a"));
	}
}
