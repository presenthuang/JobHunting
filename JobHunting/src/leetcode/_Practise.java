package leetcode;

import java.util.HashMap;
import java.util.HashSet;


public class _Practise {
	public int minCut(String s) {
		int n = s.length();
		int [] cut = new int[n+1];// number of cuts for the first k characters
		for (int i = 0; i <= n; i++) 
			cut[i] = i-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j)==s.charAt(i+j); j++) // odd length palindrome
				cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

			for (int j = 1; i-j+1 >= 0 && i+j < n && s.charAt(i-j+1) == s.charAt(i+j); j++) // even length palindrome
				cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
		}
		return cut[n];
	}
	//binary search with duplicates
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == target)
				return m;
			// from now on, A[m] != target
			if (A[l] < A[m]) {// left part is normally ordered
				if (A[l] <= target && target < A[m])// can also be target <= A[m]
					r = m - 1;						
				else
					l = m + 1;
			} else if (A[l] > A[m]) { // right part is normally ordered
				if (A[m] < target && target <= A[r]) // can also be A[m] <= target
					l = m + 1;
				else
					r = m - 1;
			} else {// A[l] == A[m] means: there are only 2 elements right now!!!
				l++;
			}
		}
		return -1;// when (l > r)
	}
	
	private int longestCommonSubsequence(String X, String Y){
		int m = X.length();
		int n = Y.length();
		int[][] LCS = new int[m+1][n+1];
		int i, j;
		
		for(i = 1; i <= m; ++i){
			for(j = 1; j <= n; ++j){
				if(X.charAt(i-1) == Y.charAt(j-1)){
					LCS[i][j] = LCS[i-1][j-1]+1;
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		String longestCommonString = "";
		i = m;
		j = n;
		
		while(LCS[i][j] > 0){
			if(X.charAt(i-1) == Y.charAt(j-1)){
				longestCommonString = X.charAt(i-1) + longestCommonString;
				i--;
				j--;
			}
			else{
				if(LCS[i-1][j] == LCS[i][j]){
					i--;
				}else{
					j--;
				}
			}
		}
		System.out.println(longestCommonString);
		return LCS[m][n];
	}
	
	public static void main(String args[]){
		double bit = 130.4;
		byte name = (byte) bit;
		long i1 = -1 >>> 2000;
		System.out.println(i1);
		_Practise p = new _Practise();
		int [] num = {1, 12, 5, 26, 7, 14, 3, 7, 2};
		for(int i = 0; i < num.length; ++i)
			System.out.print(num[i]+" ");
//		System.out.println(p.longestCommonSubsequence("ABCBDAB", "BDCABA"));
		
		int begin = 3;
		int end = -4;
		
//		System.out.println((begin & end) + ((begin ^ end) >> 1));
//		System.out.println((begin+end)/2);
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(2, 5);
//		map.put(0, 2);
		
//		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
//		map1.put(0, 2);
//		map1.put(2, 5);
		
		HashSet<Integer> Set = new HashSet<Integer>();
		HashMap<String, String> result = new HashMap<>();
		result.put(null, "temp");
		System.out.println(result.get(null));
//		if(Set.contains(map1)){
//			System.out.println();
//		}
//		map.equals(map1);
//		System.out.println(map);
//		System.out.println(map1);
//		System.out.println("231".substring(3,3));
//		
//		System.out.println(Integer.toBinaryString(~(0)+1));
		
		
//		System.out.println(p.minCut("aabb"));
	}
	
}
