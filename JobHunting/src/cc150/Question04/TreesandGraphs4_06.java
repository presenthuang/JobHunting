package cc150.Question04;

import basic.TreeNode;

public class TreesandGraphs4_06 {
//Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in
//a binary search tree. You may assume that each node has a link to its parent.
	public TreeNode inorderSucc(TreeNode n){
		if(n == null)
			return null;
		if(n.right !=  null){
			return leftMostChild(n.right);
		}else{
			TreeNode q = n;
			TreeNode x = q.parent;
			
			while(x != null && x.left != q){
				q = x;
				x = x.parent;
			}
			
			return x;
		}
	}

	private TreeNode leftMostChild(TreeNode node) {
		if(node == null)
			return node;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
}
