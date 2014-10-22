package tree.construct;

import utils.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	// Given preorder and inorder traversal of a tree, construct the binary
	// tree.
	//
	// Note:
	// You may assume that duplicates do not exist in the tree.

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int prestart = 0;
		int preend = preorder.length - 1;
		int instart = 0;
		int inend = inorder.length - 1;
		return helper(preorder, prestart, preend, inorder, instart, inend);
	}

	private TreeNode helper(int[] preorder, int prestart, int preend,
			int[] inorder, int instart, int inend) {
		if (instart > inend || prestart > preend) {
			return null;
		}
		int rootval = preorder[prestart];//root would be the first element in preorder.
		TreeNode root = new TreeNode(rootval);

		int k = 0;
		for (int i = 0; i < inorder.length; ++i) {
			if (inorder[i] == rootval) {
				k = i;
				break;
			}
		}
		//length of left tree is k - (instart + 1)
		int leftLength = k - instart;
		//root left would be from preorder second to k - instart element
		//and be from inorder first to k - 1 element
		root.left = helper(preorder, prestart + 1, prestart + leftLength, inorder, instart, k - 1);
		//root right would be from preorder k - instart + 1 to end 
		//and be from inorder k + 1 to inend
		root.right = helper(preorder, prestart + leftLength + 1, preend, inorder, k + 1, inend);

		return root;
	}
}