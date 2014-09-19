package tree.traverse;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
//	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//			For example:
//			Given binary tree {3,9,20,#,#,15,7},
//			    3
//			   / \
//			  9  20
//			    /  \
//			   15   7
//			return its level order traversal as:
//			[
//			  [3],
//			  [9,20],
//			  [15,7]
//			]
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null)
    		return result;
    	
    	helper(result,root,1);
    	return result;
    }

	private void helper(List<List<Integer>> result, TreeNode node, int level) {		
		if(node == null)
			return;
		if(level > result.size())
			result.add(new ArrayList<Integer>());
		result.get(level-1).add(node.val);
		helper(result,node.left,level+1);
		helper(result,node.right,level+1);
	}
    
    
}
