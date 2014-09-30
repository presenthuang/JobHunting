package cc150.Question04;

import basic.TreeNode;

public class TreesandGraphs4_07 {
//Design an algorithm and write code to find the first common ancestor of two nodes
//in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
//necessarily a binary search tree.
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		TreeNode temp_left = commonAncestor(root.left, p, q);
		TreeNode temp_right = commonAncestor(root.right, p, q);
		
		if(temp_left == null)
			return temp_right;
		else if(temp_right == null)
			return temp_left;
		else
			return root;
	}
}
