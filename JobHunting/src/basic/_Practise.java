package basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class _Practise {
	
	static int findnum(int length){
		int total_sum = 0;
		for(int i = 1; i < length; ++i){
			if(i % 3 == 0) {
				total_sum += i;
			}
			else if(i % 5 == 0){
				total_sum += i;
			}
		}
		return total_sum;
	}

	public static int findNumber(int pre, int next, int sum){
		if (next > 4000000){
			return sum;
		}
		int plus = pre + next;
		if(plus % 2 == 0){
			sum = sum + plus;
		}
		return findNumber(next, plus, sum);
	}
	public static boolean checknumber(int current){
		String number = String.valueOf(current);
		int length = number.length();
		for(int i = 0; i < length / 2; ++i){
			String pre = number.substring(i, i+1);
			String aft = number.substring(length - i - 1, length - i);
			if(!pre.equals(aft)){
				return false;
			}
		}
		return true;
	}
	
	public static int palindromic(){
		int finalnumber = 0;
		for (int i = 999; i > 0; --i) {
			for(int j = i; j > 0; --j){
				int number = i * j;
				if(checknumber(number)){
					if(finalnumber < number){
						finalnumber = number;
					}
					
				}
			}
		}
		return finalnumber;
	}
	
	public static int sumsquare(){
		int total = 0;
		for(int i = 1; i < 101; ++i){
			total = total + i * i;
		}
		return total;
	}
	public static int squaresum(){
		int total = 0;
		for(int i = 1; i < 101; ++i){
			total = total + i;
		}
		return (total * total);
	}
	
	public static int CalPrime(){
		//int order = 4;
		int cur = 3;
		int sum = 2;
		while(true){
			if(Validate(cur)){
				if(cur < 2000000){
					sum = sum + cur;
				}else {
					return sum;
				}			
//				order = order + 1;
//				if(order == 10001){
//					return cur;
//				}
			}
			cur = cur + 1;
		}
	}
	
	public static long Eratosthenes(){
		int magicnumber = 2000001;
		boolean [] numberpool = new boolean [magicnumber];
		long sum = 0;
		int stop = -1;
		
		
		for (int i = 0; i < numberpool.length; ++ i){
			numberpool[i] = true;
		}		
		for(int i = 2; i < magicnumber; ++i){
			if(numberpool[i]){
				for(int j = i; j < magicnumber; ++j){
					if(numberpool[j] && (j % i ==  0)){
						numberpool[j] = false;
					}
				}
				sum = sum + i;
			}
			if(i > Math.sqrt(magicnumber)){
				stop = i;
				break;
			}
		}
		for(int k = stop; k < magicnumber; ++k){
			if(numberpool[k]){
				sum = sum + k;
			}
		}
		return sum;
	}
	
	public static long bruteForceforTriangleNumber(){
		long Magic = 1;
		int iterator = 2;
		while(true){
			if(checkFactors(Magic)){
				return Magic;
			}
			Magic = Magic + iterator;
			iterator = iterator+1;
		}
	}
	
	public static boolean checkFactors(long num){
		int factors = 0;
		int length = 500;
		int sqrt = (int) Math.sqrt(num);
		if(num < length){
			return false;
		}
		for(long i = 1; i <= sqrt; ++i){
			if(num % i == 0){
				factors+=2;
			}
		}
	    if (sqrt * sqrt == num) {
	    	factors--;
	    }
		if(factors >= length){
			return true;
		}
		return false;
	}
	
	public static void Equations(){
		for(int b = 1; b < 1000; ++b){
			for(int c = 1; c < 1000; ++c){
				int left = b*b+b*c + 500000;
				int right = 1000 * b + 1000 * c;
				if(left == right){
					int a = 1000 - b - c;
					int product = a * b * c;
					System.out.println(product);
				}
			}
		}
	}
	
	public static boolean Validate(long prime){
		for(int i = 2; i < prime; ++i){
			if(prime % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static int CalculateCollatzLength(int end){
		int sequencelength = 1;
		int prelength = 4;
		int currentnumber = -1;
		long current = 0;
		Hashtable<Long, Integer> existNumber = new Hashtable<Long, Integer>();
		existNumber.put((long) 1, 4);
		//Vector<Long> existNumber = new Vector<Long>();
		for(int i = 2; i < end; ++i){
			current = i;
			//if(existNumber.contains(current)){
			//	continue;
			//}
			sequencelength = 1;
			while(current != 1){
				sequencelength++;
				if(current % 2 == 0){
					current = current /2;					
					if(current != 1 && existNumber.containsKey(current)){
						sequencelength = sequencelength + existNumber.get(current)-1;
						break;
					}
				}else{
					current = 3 * current + 1;
					if(existNumber.containsKey(current)){
						sequencelength = sequencelength + existNumber.get(current);
						break;
					}
				}
			}
			existNumber.put((long)i, sequencelength);
			if(sequencelength > prelength){
				prelength = sequencelength;
				currentnumber = i;
			}
		}
		return currentnumber;
	}
	
	
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max_length = 0;
        int cur_length = -1;
        for(int i = 0; i< length; ++i){
            String cursub = s.substring(i);
            int endpoint = cursub.length();
            while(true){
                String temp = cursub.substring(endpoint - 1, endpoint);
                String stay = cursub.substring(0, endpoint - 1);
                if(!stay.contains(temp)){
                    cur_length = stay.length() + 1;
                    break;
                }else{
                    endpoint--;
                }
            }
            if(max_length < cur_length){
                max_length = cur_length;
            }
            cur_length = -1;
        }
        return max_length;
    }
    
    public static void getGrayCode(int bitNum){
        for(int i = 0; i < (int)Math.pow(2, bitNum); i++){  
            int grayCode = (i >> 1) ^ i;
            System.out.println(grayCode);  
        }
    }  
    
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
		System.out.println(Integer.MAX_VALUE);
		int in = 1;
		byte term = (byte)0x0a;
		StringBuilder sb = new StringBuilder();
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
