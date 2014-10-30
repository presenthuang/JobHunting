package leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
//	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//			For example:
//			Given binary tree {3,9,20,#,#,15,7},
//			    3
//			   / \
//			  9  20
//			    /  \
//			   15   7
//			return its bottom-up level order traversal as:
//			[
//			  [15,7],
//			  [9,20],
//			  [3]
//			]
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return results;
        queue.offer(root);
        List<Integer> temp = new ArrayList<Integer>();
        int current=1;
        int next = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            current--;
            temp.add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
                next++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                next++;
            }
            if(current == 0) {
                results.add(temp);
                temp = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        Collections.reverse(results);
        return results;
    }
}
