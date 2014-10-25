package search;

public class SearchInsertPosition {
//	Given a sorted array and a target value, return the index if the target 
//	is found. If not, return the index where it would be if it were inserted in order.
//
//			You may assume no duplicates in the array.
//
//			Here are few examples.
//			[1,3,5,6], 5 → 2
//			[1,3,5,6], 2 → 1
//			[1,3,5,6], 7 → 4
//			[1,3,5,6], 0 → 0
	public int searchInsert(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        int pos = 0;
        //this means the element must insert in the array.
        while(l <= r){
        	pos = (l + r) / 2;
        	if(A[pos] == target){
        		return pos;
        	}
        	//go to right part of the array.
        	if(A[pos] < target){
        		l = pos + 1;
        	//go to left part of the array
        	}else {
        		r = pos - 1;
			}
        }
        return l;
    }
}