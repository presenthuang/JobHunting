package leetcode.sort;

public class SortColors {
//	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//	Note:
//	You are not suppose to use the library's sort function for this problem.
	
	
//	//counting sort version.
//    public void sortColors(int[] A) {
//        int size = A.length;
//        int [] C = new int [3];
//        for(int i = 0; i < size; ++i){
//            C[A[i]]++;
//        }
//        int iter = 0;
//        for(int i = 0; i < C.length; ++i){
//            for(int j = 0; j < C[i]; ++j){
//                A[iter++] = i;
//            }
//        }
//    }
	
	
//	http://blog.unieagle.net/2012/10/23/leetcode题目：sort-colors/
	//3 pointer version, mostly like the version of pivot in quicksort.
    public void sortColors(int[] A) {
        int length = A.length;
        int i = 0;
        int j = length - 1;
        int cur = 0;
        while(cur <= j){
            if(A[cur] == 0){
                if(cur > i){
                    swap(A, cur, i);
                    i++;
                }else{
                    cur++;
                    i++;
                }
            }else if(A[cur] == 2){
                if(cur < j){
                    swap(A, cur, j);
                    j--;
                }else{
                    return;
                }
            }else{
                cur++;
            }
        }
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
}
