package sort;

public class FirstMissingPositive {
//	Given an unsorted integer array, find the first missing positive integer.
//
//	For example,
//	Given [1,2,0] return 3,
//	and [3,4,-1,1] return 2.
//
//	Your algorithm should run in O(n) time and uses constant space.

//	http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
	
    public int firstMissingPositive(int[] A) {
    	int length = A.length;
    	int i = 0;
    	while(i < length){
    		if(i+1 != A[i] && A[i] >= 1 && A[i] <= length && A[A[i]-1] != A[i]){
    			int actval = A[i]-1;
    			int temp = A[actval];
    			A[actval] = A[i];
    			A[i] = temp;
    		}else{
    			i++;
    		}
    		for(int j = 0; j < A.length; ++j){
    			System.out.print(A[j] + " ");
    		}
    		System.out.println();
    			
    	}
    	
    	for(i = 0; i < length; ++i){
    		if(A[i] != i + 1)
    			return i+1;
    	}
    	return length+1;
    }
    
    public static void main(String[] args) {
		FirstMissingPositive fi = new FirstMissingPositive();
		int [] A = {3,4,-1,1};
		System.out.println(fi.firstMissingPositive(A));
	}
}
