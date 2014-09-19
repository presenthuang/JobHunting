package dynamicProgramming;

public class InterleavingString {
// ==================================================================  //  
//	Interleaving String
//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.
//==================================================================  //  
    public boolean isInterleave(String s1, String s2, String s3) {
        if(!(s3 != null || s1 != null || s2 != null))
        	return true;
        if(s3 == null)
        	return false;
        if(s1.length() + s2.length() != s3.length())
        	return false;
        boolean [][] match = new boolean[s1.length()+1][s2.length()+1];
        match[0][0] = true;
        
        int i = 1;
        while(i <= s1.length() && s1.charAt(i-1) == s3.charAt(i-1)){
        	match[i][0] = true;
        	i++;
        }
        
        i = 1;
        while(i <= s2.length() && s2.charAt(i-1) == s3.charAt(i-1)){
        	match[0][i] = true;
        	i++;
        }
        for(i = 1; i < s1.length()+1; i++){
        	for(int j = 1; j < s2.length()+1; ++j){
        		if(s3.charAt(i+j-1) == s1.charAt(i-1))
        			match[i][j] = match[i][j] || match[i-1][j];
        		if(s3.charAt(i+j-1) == s2.charAt(j-1)){
        			match[i][j] = match[i][j] || match[i][j-1];
        		}
        	}
        }
        return match[s1.length()][s2.length()];
    }
}
