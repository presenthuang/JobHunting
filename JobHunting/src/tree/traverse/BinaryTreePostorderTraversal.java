package tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import basic.TreeNode;

public class BinaryTreePostorderTraversal {
//	Given a binary tree, return the postorder traversal of its nodes' values.
//
//			For example:
//			Given binary tree {1,#,2,3},
//			   1
//			    \
//			     2
//			    /
//			   3
//			return [3,2,1].
//
//			Note: Recursive solution is trivial, could you do it iteratively?
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        	return result;
        LinkedList<TreeNode> child = new LinkedList<>();
        LinkedList<TreeNode> parent = new LinkedList<>();
        
        child.push(root);
        while(!child.isEmpty()){
        	TreeNode curNode = child.pop();
        	parent.push(curNode);
        	if(curNode.left != null){
        		child.push(curNode.left);
        	}
        	if(curNode.right != null){
        		child.push(curNode.right);
        	}
        }
        
        while(!parent.isEmpty()){
        	result.add(parent.pop().val);
        }
        
        return result;
    }
}
