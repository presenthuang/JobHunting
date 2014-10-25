package leetcode.tree.search;

import utils.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
//	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0){
        	return null;
        }
    	int length = num.length;
    	return sortedArrayToBST(num, 0, length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end){
    	if(start > end)
    		return null;
    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = sortedArrayToBST(num, start, mid-1);
    	root.right = sortedArrayToBST(num, mid+1, end);
    	return root;
    }
}
