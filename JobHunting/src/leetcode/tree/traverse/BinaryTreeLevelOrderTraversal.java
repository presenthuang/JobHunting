package leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

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
	//Recursion Method, not fast
//    public List<List<Integer>> levelOrder(TreeNode root) {
//    	List<List<Integer>> result = new ArrayList<List<Integer>>();
//    	if(root == null)
//    		return result;
//    	
//    	helper(result,root,1);
//    	return result;
//    }
//
//	private void helper(List<List<Integer>> result, TreeNode node, int level) {		
//		if(node == null)
//			return;
//		if(level > result.size())
//			result.add(new ArrayList<Integer>());
//		result.get(level-1).add(node.val);
//		helper(result,node.left,level+1);
//		helper(result,node.right,level+1);
//	}
    
//	Combine with the other traverse
//	Iterative method
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			result.add(level);
		}
		return result;
	}
    
}
