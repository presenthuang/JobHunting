package leetcode.tree.recursion;

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
        helper(results, root, sum, new ArrayList<Integer>());
        return results;
    }
    
    private void helper(List<List<Integer>> results, TreeNode root, int remain, List<Integer> current){
        if(root == null){
            return;
        }
        current.add(root.val);
        remain -= root.val;
        if(root.left == null && root.right == null && remain == 0){//leaf node
            results.add(new ArrayList<Integer>(current));
        }else{
            helper(results, root.left, remain, current);
            helper(results, root.right, remain, current);
        }
        current.remove(current.size()-1);    
    }
}
