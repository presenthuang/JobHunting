package leetcode.array;

public class SearchinRotatedSortedArrayII {
//	Follow up for "Search in Rotated Sorted Array":
//		What if duplicates are allowed?
//
//		Would this affect the run-time complexity? How and why?
//
//		Write a function to determine if a given target is in the array.
	
//	kind of different with I, just the condition that if they are the same
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
        	return false;
        }
        int l = 0;
        int r = A.length - 1;
        while(l <= r){
        	int m = (l + r) / 2;
        	if(A[m] == target)
        		return true;
    		if(A[l] < A[m]){//if left smaller than mid, then left is correct order
    			if(A[l] <= target && target < A[m]){//if target in the left part.
    				r = m - 1;
    			}else{//target in the right part.
    				l = m + 1;
    			}
    		}else if(A[l] > A[m]){//if left larger than middle, then left is not correct.
    			if(A[m] < target && target <= A[r]){//if target in the right part.
    				l = m + 1;
    			}else{//target in the left part
    				r = m - 1;
    			}
    		}else {
				l++;//just move the left for one because we cant decide where it is with duplicates.
			}
        }
        return false;
    }
}