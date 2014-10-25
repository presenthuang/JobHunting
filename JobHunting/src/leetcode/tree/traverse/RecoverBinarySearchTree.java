package leetcode.tree.traverse;

import utils.TreeNode;

public class RecoverBinarySearchTree {
//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. 
//Could you devise a constant space solution?
    TreeNode firstNode,secondNode;
    TreeNode preNode;
    public void recoverTree(TreeNode root) {
        if(root == null)
        	return;
        inorder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
	private void inorder(TreeNode root) {
		if(root == null)
			return;
		inorder(root.left);
		if(preNode != null && root.val < preNode.val){
		    if(firstNode == null){
			firstNode = preNode;
			secondNode = root;
    		}else{
    			secondNode = root;
    		}
		}
		preNode = root;
		inorder(root.right);
	}
}
