package leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreeInorderTraversal {
//	Given a binary tree, return the inorder traversal of its nodes' values.
//
//			For example:
//			Given binary tree {1,#,2,3},
//			   1
//			    \
//			     2
//			    /
//			   3
//			return [1,3,2].
//
//			Note: Recursive solution is trivial, could you do it iteratively?
	
	//iteratively traverse.
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//        if(root == null){
//            return result;
//        }
//        TreeNode cur = root;
//        while(!stack.isEmpty() || cur != null){
//            if(cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }else{
//                cur = stack.pop();
//                result.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return result;
//    }
//    
	
    //recursive traverse
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helper(result, root);
		return result;
	}

	private void helper(List<Integer> result, TreeNode root) {
		if(root == null){
			return;
		}
		helper(result, root.left);
		result.add(root.val);
		helper(result, root.right);
	}
}