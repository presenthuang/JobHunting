package leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
// ==================================================================  //  
//  Binary Tree Zigzag Level Order Traversal  
//  Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//  (ie, from left to right, then right to left for the next level and alternate between).
//
//  		For example:
//  		Given binary tree {3,9,20,#,#,15,7},
//  3
// / \
//9  20
//  /  \
// 15   7
//return its zigzag level order traversal as:
//[
//[3],
//[20,9],
//[15,7]
//]
//==================================================================  // 
	
	
	//use a queue to reverse every level when we meet a node.
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if(root == null)
//        	return result;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        boolean inorder = true;
//        int currentdepth = 1;
//        while(!queue.isEmpty()){
//        	inorder = inorder?false:true;
//        	List<Integer> level = new ArrayList<Integer>();
//        	int iter = currentdepth;
//        	currentdepth = 0;
//        	for(int i = 0; i < iter; ++i){
//        		TreeNode node = queue.poll();
//        		level.add(node.val);
//            	if(node.left != null){
//            		queue.add(node.left);
//            		currentdepth++;
//            	}
//            	if(node.right != null){
//            		queue.add(node.right);
//            		currentdepth++;
//            	}
//        	}
//        	if(!inorder){
//        		result.add(level);
//        	}else{
//        		Collections.reverse(level);
//        		result.add(level);
//        	}
//        }
//        return result;
//    }
	
	
	//use 2 while iterative.
	public ArrayList<List<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		LinkedList<TreeNode> currLevel = new LinkedList<>();
		LinkedList<TreeNode> nextLevel = new LinkedList<>();
		LinkedList<TreeNode> tmp;
		currLevel.push(root);
		boolean normalOrder = true;
		while(!currLevel.isEmpty()){//secure that the whole part is not empty
			ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
			while (!currLevel.isEmpty()) {//secure the current one is not empty
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
			result.add(currLevelResult);//find one level and be sure to add this to result.
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
		}
		return result;
	}
}