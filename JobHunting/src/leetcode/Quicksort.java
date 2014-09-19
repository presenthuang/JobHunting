package leetcode;

public class Quicksort {
	
	public void quicksort(int[] num, int i, int j){
		int index = partition(num,i,j);//every time quicksort would leave one element to be the correct position
		if(i < index - 1){//
			quicksort(num, i, index-1);
		}
		if(index < j){
			quicksort(num, index, j);
		}
	}
	
	private int partition(int[] num, int left, int right) {
		int i = left;
		int j = right;
		int pivot = num[(left + right) / 2];
		while(i <= j){
			while(num[i] < pivot)
				i++;
			while(num[j] > pivot)
				j--;
			if(i <= j){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					i++;
					j--;
			}
		}
		return i;
	}
}
