package edu.columbia.xh2211.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _Practise {
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
	
	public static void main(String args[]){
		int begin = 3;
		int end = -4;
		
//		System.out.println((begin & end) + ((begin ^ end) >> 1));
//		System.out.println((begin+end)/2);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(2, 5);
		map.put(0, 2);
		
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(0, 2);
		map1.put(2, 5);
		
		HashSet<Integer> Set = new HashSet<Integer>();
		if(Set.contains(map1)){
			System.out.println();
		}
		map.equals(map1);
//		System.out.println(map);
//		System.out.println(map1);
		System.out.println("231".substring(3,3));
	}
	
}
