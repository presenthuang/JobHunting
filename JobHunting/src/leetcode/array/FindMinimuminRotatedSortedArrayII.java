package leetcode.array;

public class FindMinimuminRotatedSortedArrayII {
//	Follow up for "Find Minimum in Rotated Sorted Array":
//		What if duplicates are allowed?
//
//		Would this affect the run-time complexity? How and why?
//		Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//		Find the minimum element.
//
//		The array may contain duplicates.
    public int findMin(int[] num) {
        int left = 0;
        int right = num.length-1;
        while(left < right){
            int mid = (left+right)/2;
            if(num[left] < num[right]){
                return num[left];
            }
            if(num[left] < num[mid]){
                left = mid+1;
            }else if(num[left] > num[mid]){
                right = mid;
            }else{
                 left++;
            }
        }
        return num[left];
    }
}
