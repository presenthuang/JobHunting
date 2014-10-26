package leetcode.greedy;

public class JumpGame {
//	Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//	Each element in the array represents your maximum jump length at that position.
//
//	Determine if you are able to reach the last index.
//
//	For example:
//	A = [2,3,1,1,4], return true.
//
//	A = [3,2,1,0,4], return false.
	
    public boolean canJump(int[] A) {
        if(A.length == 0){
            return true;
        }
        int length = A.length;
        int max = 0;
        for(int i = 0; i < length; ++i){
            if(i <= max){
                max = Math.max(max, A[i]+i);
            }
            if(max >= length-1){
                return true;
            }
        }
        return false;
    }
}
