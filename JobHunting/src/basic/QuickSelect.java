package basic;

public class QuickSelect {
	private int partition(int[] num, int left, int right) {//partition to find one element in the array.
		int pivotVal = num[right];//choose the rightmost element as pivot
		int returnIndex = left;//start from left of the subarray.
		for(int i = left; i < right; ++i){//loop the whole array and swap all the elements that are smaller than the pivot.
			if(num[i] <= pivotVal){
					int temp = num[i];//swap array[i] and array[returnIndex]
					num[i] = num[returnIndex];
					num[returnIndex] = temp;
					returnIndex++;
			}
		}
		num[right] = num[returnIndex];//returnIndex should be the correct index for pivot, swap array[right] and array[returnIndex]
		num[returnIndex] = pivotVal;
		return returnIndex;
	}
	
	//return n-th element from the list.(start from 0)
	public int quickSelect(int[] num, int n){
		int s = 0;
		int e = num.length-1;
		while(s <= e){
			int pivotIndex = partition(num, s, e);
			if(n == pivotIndex){
				return num[pivotIndex];
			}else if(n < pivotIndex){
				e = pivotIndex - 1;
			}else {
				s = pivotIndex + 1;
			}
		}
		return num[0];
	}
	
	public static void main(String[] args) {
		int[]nums = {4};
		System.out.println(new QuickSelect().quickSelect(nums, 3));
	}
}
