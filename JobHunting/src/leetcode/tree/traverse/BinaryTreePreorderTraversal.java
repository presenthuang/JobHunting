package leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreePreorderTraversal {
//	Given a binary tree, return the preorder traversal of its nodes' values.
//
//			For example:
//			Given binary tree {1,#,2,3},
//			   1
//			    \
//			     2
//			    /
//			   3
//			return [1,2,3].
//
//			Note: Recursive solution is trivial, could you do it iteratively?
	
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root != null)
        	stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	result.add(cur.val);
        	if(cur.right != null){
        		stack.push(cur.right);
        	}
        	if(cur.left != null){
        		stack.push(cur.left);
        	}
        }
        return result;
    }
}
