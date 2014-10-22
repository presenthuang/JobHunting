package tree.recursion;

import utils.TreeNode;

public class DiameterOfTree {
	static int diameterOfTree(TreeNode root) {
		/* For your reference
		   class Node {
		       Node left, right;
		       int data;
		               Node(int newData) {
		           left = right = null;
		           data = newData;
		       }
		   }
		*/     
		    if(root == null)
		        return 0;
		    return getDiameter(root);
		}

		static int getDiameter(TreeNode root){
		    if(root == null)
		        return 0;
		    int rootDiameter = depth(root.left) + depth(root.right) + 1;
		    int leftDiameter = getDiameter(root.left);
		    int rightDiameter = getDiameter(root.right);
		    
		    return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
		}

		static int depth(TreeNode root){
		    if(root == null)
		        return 0;
		    return Math.max(depth(root.left),depth(root.right)) + 1;
		}


}
