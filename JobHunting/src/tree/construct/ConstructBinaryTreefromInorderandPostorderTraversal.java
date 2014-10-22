package tree.construct;

import utils.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	// Given inorder and postorder traversal of a tree, construct the binary
	// tree.
	//
	// Note:
	// You may assume that duplicates do not exist in the tree.

	// http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int instart = 0;
		int inend = inorder.length - 1;
		int poststart = 0;
		int postend = postorder.length - 1;
		return helper(inorder, postorder, instart, inend, poststart, postend);
	}

	private TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
		if (instart > inend || poststart > postend) {
			return null;
		}
		int rootval = postorder[postend];
		TreeNode root = new TreeNode(rootval);
		int k = 0;
		for (int i = 0; i < inorder.length; ++i) {
			if (inorder[i] == rootval) {
				k = i;
				break;
			}
		}
		int leftLength = k  - instart;
		//Becuase k is not the length, it it need to -( inStart + 1 ) to get the length
		root.left = helper(inorder, postorder, instart, k - 1, poststart, poststart + leftLength - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
		root.right = helper(inorder, postorder, k + 1, inend, poststart + leftLength, postend - 1);
		return root;
	}
	
	
	public static void main(String[] args) {
		int[] inorder = {4, 2, 5, 1,  6, 7, 3, 8};
		int[] postorder = {4, 5, 2, 6, 7, 8, 3, 1};
		new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
	}
}
