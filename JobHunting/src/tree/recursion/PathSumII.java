package tree.recursion;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class PathSumII {
//	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//	For example:
//	Given the below binary tree and sum = 22,
//	              5
//	             / \
//	            4   8
//	           /   / \
//	          11  13  4
//	         /  \    / \
//	        7    2  5   1
//	return
//	[
//	   [5,4,11,2],
//	   [5,8,4,5]
//	]
	
//	simple dfs method
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> results = new ArrayList<List<Integer>>();
	        if(root == null || (root.left == null && root.right == null && root.val != sum))
	        	return results;
	        helper(results, root, sum, new ArrayList<Integer>(), 0);
	        return results;
	 }

	private void helper(List<List<Integer>> results, TreeNode root, int sum, ArrayList<Integer> result, int current) {
		if(root == null)
			return;
		if(root.left == null && root.right == null){//get to a leaf, need to verify
			if(current + root.val == sum){
				result.add(root.val);
				results.add(new ArrayList<>(result));
			}
			return;
		}
		result.add(root.val);
		helper(results, root.left, sum, new ArrayList<Integer>(result), current+root.val);
		helper(results, root.right, sum, new ArrayList<Integer>(result), current+root.val);
	}
}
