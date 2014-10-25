package leetcode.array;

public class SearchinRotatedSortedArray {
//	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//	You are given a target value to search. If found in the array return its 
//	index, otherwise return -1.
//
//	You may assume no duplicate exists in the array.
	
//	use binary search to find the correct position.
//	No duplicates, so we don't need to afraid the length.
    public int search(int[] A, int target) {
    	if(A == null || A.length == 0){
    		return -1;
    	}
    	int begin = 0;
    	int end = A.length - 1;
    	while(begin <= end){
    		int mid = (begin+end)/2;
    		if(A[mid] == target){
    			return mid;
    		}else{
    			if(A[begin] <= A[mid]){//This means the left part is in correct order.
    				if(A[begin] <= target && target <= A[mid]){//if target is in the left part.
    					end = mid - 1;
    				}else{//target is in the right part.
    					begin = mid + 1;
    				}
    			}else{//This means left is not in correct order, we have to find it in the whole part.
    				if(A[mid] >= target || target >= A[begin]){//This is going to be out of the bounds in [begin, mid]
    					end = mid - 1;
    				}else{//then it must in the right part.
    					begin = mid + 1;
    				}
    			}
    		}
    	}
    	return -1;
    }
}
