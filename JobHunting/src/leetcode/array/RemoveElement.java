package leetcode.array;

public class RemoveElement {
//	Given an array and a value, remove all instances of that value in place and return the new length.
//
//			The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        if(length == 0)
        	return length;
        for(int i = 0; i < length;){
        	if(A[i] == elem){
        		int temp = A[length-1];
        		A[length-1]=A[i];
        		A[i] = temp;
        		length--;
        	}else{
        		i++;
        	}
        }
        return length;
    }


}
