package leetcode.array;

public class FindMinimuminRotatedSortedArray {
//	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//	Find the minimum element.
//
//	You may assume no duplicate exists in the array.
    public int findMin(int[] num) {
        int length = num.length;
        if(length <= 0){
            return -1;
        }
        int l = 0;
        int r = length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(num[l] <= num[mid]){//if the left part is only in ascending order
                if(num[mid] < num[r]){//if the right part is also ascending
                    return num[l];
                }else{//if the right has value smaller than mid
                    l = mid+1;
                }
            }else{//if left is not in ascending order
                r = mid;
            }
        }
        return num[l];
    }
}
