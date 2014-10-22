package cc150.Question04;

import utils.TreeNode;

public class TreesandGraphs4_05 {
//Implement a function to check if a binary tree is a binary search tree.
	public boolean isBST(TreeNode root){
		return isBST(root,null,null);
	}

	private boolean isBST(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		if((min != null && root.val <= min) || (max != null && root.val > max)){
			return false;
		}
		if(!isBST(root.left, min, root.val) || !isBST(root.right, root.val, max)){
			return false;
		}
		return true;
	}
}
