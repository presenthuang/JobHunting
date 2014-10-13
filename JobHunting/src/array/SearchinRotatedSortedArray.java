package array;

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
    			if(A[begin] <= A[mid]){
    				if(A[begin] <= target && target <= A[mid]){
    					end = mid - 1;
    				}else{
    					begin = mid + 1;
    				}
    			}else{
    				if(A[mid] >= target || A[begin] <= target){
    					end = mid - 1;
    				}else{
    					begin = mid + 1;
    				}
    			}
    		}
    	}
    	return -1;
    }
}
