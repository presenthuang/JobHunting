package array;

import java.util.Arrays;

public class NextPermutation {
//	Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//	The replacement must be in-place, do not allocate extra memory.
//
//	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//	1,2,3 → 1,3,2
//	3,2,1 → 1,2,3
//	1,1,5 → 1,5,1
	
//	http://nayuki.eigenstate.org/page/next-lexicographical-permutation-algorithm
	private void swap(int[] num, int l, int r){
		int temp = num[l];
		num[l] = num[r];
		num[r] = temp;
	}
	
    public void nextPermutation(int[] num) {
        if(num == null)
        	return;
     // Find longest non-increasing suffix
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i]){//from right to left, increasing order.
        	i--;
        }
     // Now i is the head index of the suffix

        // Test if num is already in the last one of permutation.
        if (i <= 0){
        	Arrays.sort(num);
        	return;
        }
        
        // Let num[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = num.length - 1;
        while(num[j] <= num[i-1]){
        	j--;
        }
     // Now the value array[j] will become the new pivot
        // Assertion: j >= i
     // Swap the pivot with j
        swap(num, i-1, j);
     // Reverse the suffix
        j = num.length-1;
        while(i < j){
        	swap(num,i,j);
        	i++;
        	j--;
        }
    }
}
