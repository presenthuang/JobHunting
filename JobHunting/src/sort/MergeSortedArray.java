package sort;

public class MergeSortedArray {
//	Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//	Note:
//	You may assume that A has enough space 
//	(size that is greater or equal to m + n) to hold additional elements from B. 
//	The number of elements initialized in A and B are m and n respectively.
	
//	have an solution with only constant space
    public void merge(int A[], int m, int B[], int n) {
    	int pos = m+n-1;
    	int pos_a = m-1;
    	int pos_b = n-1;
    	if (pos_b < 0)
    		return;
    	while(pos >= 0){
    		if(pos_a < 0){
    			A[pos--] = B[pos_b--];
    		}else if(pos_b < 0){
    			A[pos--] = A[pos_a--];
    		}else if (A[pos_a] > B[pos_b]){
    			A[pos--] = A[pos_a--];
    		}else if (A[pos_a] <= B[pos_b]){
    			A[pos--] = B[pos_b--];
    		}
    	}
    }
}
