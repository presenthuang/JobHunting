package leetcode.tree.recursion;

import utils.TreeNode;

public class MaximumDepthofBinaryTree {
//	Given a binary tree, find its maximum depth.
//
//	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
    public int maxDepth(TreeNode root) {
        if(root == null){//hit the null node
            return 0;
        }
        if(root.left == null && root.right == null){//find a leaf node
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left > right){
            return left+1;
        }else{
            return right+1;
        }
    }
}
