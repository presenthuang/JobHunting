package basic;

public class QuickSort {

	public void quicksort(int[] num, int i, int j) {
		if (i < j) {
			int index = partition(num, i, j);// every time quicksort would leave
												// one element to be the correct
												// position
			quicksort(num, i, index - 1);
			quicksort(num, index + 1, j);
		}
	}

	private int partition(int[] num, int left, int right) {// partition to find
															// one element in
															// the array.
		int pivotVal = num[right];// choose the rightmost element as pivot
		int returnIndex = left;// start from left of the subarray.
		for (int i = left; i < right; ++i) {// loop the whole array and swap all
											// the elements that are smaller
											// than the pivot.
			if (num[i] <= pivotVal) {
				int temp = num[i];// swap num[i] and num[returnIndex]
				num[i] = num[returnIndex];
				num[returnIndex] = temp;
				returnIndex++;
			}
		}
		num[right] = num[returnIndex];// returnIndex should be the correct index
										// for pivot, swap num[right] and
										// num[returnIndex]
		num[returnIndex] = pivotVal;
		return returnIndex;
	}
	public static void main(String[] args) {
		int[] num = {1, 2, 2, 3, 3, 3, 4, 5, 5, 7, 8, 56};
		new QuickSort().quicksort(num, 0, num.length-1);
		for(int i = 0; i < num.length; ++i){
			System.out.print(num[i] + " ");
		}
	}
}
