package leetcode.general;

public class SingleNumberII {
//	Given an array of integers, every element appears three times except for one. Find that single one.
//
//	Note:
//	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	public int singleNumber(int[] A) {
		int [] countBits = new int[32];
		int result = 0;
		for(int i = 0; i < 32; ++i){
			for(int j = 0; j < A.length; ++j){
				if((A[j] >> i & 1) == 1){
					countBits[i]++;
				}
			}
			result |= ((countBits[i] % 3)<<i);
		}
		return result;
	}
}
