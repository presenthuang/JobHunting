package leetcode.dynamicProgramming;

public class DistinctSubsequences {
// ==================================================================  //  
//  Distinct Subsequences
//  Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//  A subsequence of a string is a new string which is formed from the original string 
//  by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
//  (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//  Here is an example:
//  S = "rabbbit", T = "rabbit"
//
//  Return 3.
//==================================================================  //  
//	dp problem
//	subproblem is:
//	W(i,j) = W(i-1, j) + W(i-1,j-1) if charAt(i-1) == charAt(j-1)
//	W(i,j) = W(i-1, j) otherwise
	
//	此题需要使用大数运算。使用一点 DP 即可。关键是如何得到递推关系，可以这样想，设母串的长度为 j，  
//	子串的长度为 i，我们要求的就是长度为 i 的子串在长度为 j 的母串中出现的次数，设为 t[i][j]，
//	若母串的最后一个字符与子串的最后一个字符不同，则长度为 i 的子串在长度为 j 的母串中出现的次数就是母串的前 j - 1 个字符中子串出现的次数，
//	即 t[i][j] = t[i][j - 1]，若母串的最后一个字符与子串的最后一个字符相同，那么除了前 j - 1 个字符出现字串的次数外，
//	还要加上子串的前 i - 1 个字符在母串的前 j - 1 个字符中出现的次数，即 t[i][j] = t[i][j - 1] + t[i - 1][j - 1]。  
	
    public int numDistinct(String S, String T) {
    	int [][] table = new int[S.length()+1][T.length()+1];
    	for(int i = 0; i < S.length(); ++i){
    		table[i][0] = 1;
    	}
    	for(int i = 1; i <= S.length(); ++i){
    		for(int j = 1; j <= T.length(); ++j){
    			if(S.charAt(i-1) == T.charAt(j-1)){
    				table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
    			}else{
    				table[i][j] += table[i - 1][j];
    			}
    		}
    	}
    	for(int i = 0; i < table.length; ++i){
    		for(int j = 0; j < table[0].length; ++j){
    			System.out.print(table[i][j] + " ");
    		}
    		System.out.println();
    	}
    	return table[S.length()][T.length()];
    }
    
    public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(new DistinctSubsequences().numDistinct(S, T));
	}
}
