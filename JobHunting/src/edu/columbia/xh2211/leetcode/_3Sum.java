package edu.columbia.xh2211.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
	// ================================================================== //
	// Given an array S of n integers, are there elements a, b, c in S such that
	// a + b + c = 0?
	// Find all unique triplets in the array which gives the sum of zero.
	//
	// Note:
	// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b
	// ≤ c)
	// The solution set must not contain duplicate triplets.
	// For example, given array S = {-1 0 1 2 -1 -4},
	//
	// A solution set is:
	// (-1, 0, 1)
	// (-1, -1, 2)
	// ================================================================== //
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; ++i) {
			if (i != 0 && num[i] == num[i - 1])
				continue;

			int j = i + 1;
			int k = num.length - 1;
			int num1, num2, num3;
			num1 = num[i];

			while (j < k) {
				num2 = num[j];
				num3 = num[k];
				if (num1 + num2 + num3 == 0) {
					List<Integer> result = new ArrayList<Integer>();
					result.add(num1);
					result.add(num2);
					result.add(num3);
					results.add(result);
					j++;
					k--;
					while (j < k && num[j] == num[j - 1])
						j++;
					while (j < k && num[k] == num[k + 1])
						k--;
				} else if (num1 + num2 + num3 > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return results;
	}

}
