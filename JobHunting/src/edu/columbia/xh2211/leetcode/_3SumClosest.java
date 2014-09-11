package edu.columbia.xh2211.leetcode;

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
		Arrays.sort(num);
		int gap = Integer.MAX_VALUE;
		int returnval = gap;
		for (int i = 0; i < num.length - 2; ++i) {
			if (i != 0 && num[i - 1] == num[i])
				continue;
			int j = i + 1;
			int k = num.length - 1;
			int num1, num2, num3;
			num1 = num[i];
			while (j < k) {
				num2 = num[j];
				num3 = num[k];
				int total = num1 + num2 + num3;
				if (Math.abs(total - target) < gap) {
					returnval = total;
				}
				gap = Math.abs(total - target) < gap ? Math.abs(total - target)
						: gap;
				if (total - target < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return returnval;
	}
}
