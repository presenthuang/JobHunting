package edu.columbia.xh2211.leetcode;

public class MedianofTwoSortedArrays {
//	There are two sorted arrays A and B of size m and n respectively. 
//	Find the median of the two sorted arrays. 
//	The overall run time complexity should be O(log (m+n)).
	
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if((m + n) % 2 == 0)
            return (findkthElement(A, B, (m+n)/2, 0, m-1, 0, n-1) 
            		+ findkthElement(A, B, (m+n)/2-1, 0, m-1, 0, n-1)) * 0.5;
        return (double) findkthElement(A, B, (m+n)/2, 0, m-1, 0, n-1);
    }
    
    //Can be converted to find the kth element in two sorted arrays
    public int findkthElement(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd){
        int lengtha = aEnd - aStart + 1;
        int lengthb = bEnd - bStart + 1;
        if(lengtha == 0)
            return B[bStart+k];
        if(lengthb == 0)
            return A[aStart+k];
        if(k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        int meda = lengtha * k / (lengtha + lengthb);
        int medb = k - meda - 1;
        meda += aStart;
        medb += bStart;
        if(A[meda] > B[medb]){
            k = k - (medb - bStart + 1);
            aEnd = meda;
            bStart = medb + 1;
        }else{
            k = k - (meda - aStart + 1);
            bEnd = medb;
            aStart = meda + 1;
        }
        return findkthElement(A, B, k, aStart, aEnd, bStart, bEnd);
        
    }
}
