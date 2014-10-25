package leetcode.search;

public class SearchforaRange {
//	Given a sorted array of integers, find the starting and ending position of a given target value.
//
//	Your algorithm's runtime complexity must be in the order of O(log n).
//
//	If the target is not found in the array, return [-1, -1].
//
//	For example,
//	Given [5, 7, 7, 8, 8, 10] and target value 8,
//	return [3, 4].
	
//	be careful with binary search problem.
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1,-1};
        int start = 0;
        int end = A.length - 1;
        while(start < end){
        	int mid = (start + end) / 2;
        	if(A[mid] < target){
        		start = mid + 1;
        	}else{
        		end = mid;
        	}
        }
        int low;
        if(A[start] != target){
        	return result;
        }else{
        	low = start;
        }
        start = 0;
        end = A.length - 1;
        while(start < end){
        	int mid = (start + end) / 2;
        	if(A[mid] < target + 1){
        		start = mid + 1;
        	}else {
				end = mid;
			}
        }
        int high = A[start] == target ? start : start - 1;
        result[0] = low;
        result[1] = high;
        return result;
    }

	
}
