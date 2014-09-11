package edu.columbia.xh2211.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	 /**
     * Definition for binary tree
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      } 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
        	return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean inorder = true;
        int currentdepth = 1;
        while(!queue.isEmpty()){
        	inorder = inorder?false:true;
        	List<Integer> level = new ArrayList<Integer>();
        	int iter = currentdepth;
        	currentdepth = 0;
        	for(int i = 0; i < iter; ++i){
        		TreeNode node = queue.poll();
        		level.add(node.val);
            	if(node.left != null){
            		queue.add(node.left);
            		currentdepth++;
            	}
            	if(node.right != null){
            		queue.add(node.right);
            		currentdepth++;
            	}
        	}
        	if(!inorder){
        		result.add(level);
        	}else{
        		Collections.reverse(level);
        		result.add(level);
        	}
        }
        return result;
    }
}
