package leetcode.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
//	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//	For example,
//	Given [100, 4, 200, 1, 3, 2],
//	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//	Your algorithm should run in O(n) complexity.
	
	
	//for this problem, we could use a set to keep track of all the possible numbers that could be in the sequence.
	public int longestConsecutive(int[] num) {
		if(num == null){
			return 0;
		}
		HashSet<Integer> set = new HashSet<>();
		int length = num.length;
		int max = 1;
		for(int i = 0; i < length; ++i){
			set.add(num[i]);
		}
		for(int e : num){
			int left = e - 1;
			int right = e + 1;
			int count = 1;
			
			while(set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
    }
}
