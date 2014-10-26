package leetcode.array;

import java.util.Arrays;

public class _3SumClosest {
	// ================================================================== //
	// 3Sum Closest
	// Given an array S of n integers, find three integers in S such that the
	// sum is closest to a given number, target.
	// Return the sum of the three integers. You may assume that each input
	// would have exactly one solution.
	//
	// For example, given array S = {-1 2 1 -4}, and target = 1.
	//
	// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	// ================================================================== //
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3){
            return 0;
        }
        Arrays.sort(num);
        int gap = Integer.MAX_VALUE;
        int returnval = Integer.MAX_VALUE;
        for(int i = 0; i < num.length - 2; ++i){
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                int result = num[i] + num[j] + num[k];
                int newGap = Math.abs(target-result);
                if(newGap < gap){
                    gap = newGap;
                    returnval = result;
                }
                if(result - target < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return returnval;        
    }
}
