package leetcode.general;

public class SingleNumber {
//	Given an array of integers, every element appears twice except for one. Find that single one.
//
//	Note:
//	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	public int singleNumber(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < A.length; ++i){
            result = result ^ A[i];
        }
        return result;
    }
}
