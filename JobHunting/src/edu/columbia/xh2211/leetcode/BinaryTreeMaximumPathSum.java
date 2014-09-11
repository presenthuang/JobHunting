package edu.columbia.xh2211.leetcode;

public class BinaryTreeMaximumPathSum {
// ==================================================================  //  
//  Binary Tree Maximum Path Sum
//  Given a binary tree, find the maximum path sum.
//
//  The path may start and end at any node in the tree.
//
//  For example:
//  Given the below binary tree,
//
//         1
//        / \
//       2   3
//  Return 6.
//==================================================================  //
	 /**
     * Definition for binary tree
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }  
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
        	return 0;
        if(root.left == null && root.right == null)
        	return root.val;
        helper(root);
        return max;
    }
    
    public int helper(TreeNode node){
    	if(node == null)
    		return 0;
    	int left = Math.max(helper(node.left), 0);
    	int right = Math.max(helper(node.right), 0);
    	int nval = node.val;
    	
    	max = Math.max(nval+left+right, max);
    	
    	return node.val + Math.max(left, right);
    }
}
