package cc150.Question09;

public class RecursionandDynamicProgramming9_03 {
//A magic index in an array A[1...n-1] is defined to be an index such that A[i] = 
//i. Given a sorted array of distinct integers, write a method to find a magic index, if
//one existes, in array A.
//	What if the values are not distinct.
	public static int magicFast(int [] array, int start, int end){
		if(end < start || start < 0 || end >= array.length){
			return -1;
		}
		int mid = (start + end)/2;
		if(array[mid] == mid)
			return mid;
		else if(array[mid] > mid){
			return magicFast(array, start, mid - 1);
		}else{
			return magicFast(array, mid + 1, end);
		}
	}
	
	public static int magicFast(int[] array){
		return magicFast(array, 0, array.length);
	}
	
	public static int magicFastDup(int[] array, int start, int end){
		if(end < start || start < 0 || end >= array.length){
			return -1;
		}
		int mid = (start+end)/2;
		int midValue = array[mid];
		if(mid == midValue){
			return mid;
		}else if(midValue > mid){
			end = Math.min(mid-1, midValue);
			int left = magicFastDup(array,start,end);
			if(left >= 0)
				return left;
		}else{
			start = Math.max(mid+1, midValue);
			int right = magicFastDup(array,start,end);
			if(right >= 0)
				return right;
		}
		return -1;
	}
}
