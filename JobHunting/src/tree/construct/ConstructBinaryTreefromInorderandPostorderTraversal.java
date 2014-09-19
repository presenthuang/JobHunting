package tree.construct;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
//	Given inorder and postorder traversal of a tree, construct the binary tree.
//
//	Note:
//	You may assume that duplicates do not exist in the tree.
	
//	http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	int instart = 0;
    	int inend = inorder.length-1;
    	int poststart = 0;
    	int postend = postorder.length-1;
    	
    	return helper(inorder, postorder, instart, inend, poststart, postend);
    }
	private TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
		if(instart > inend || poststart > postend){
			return null;
		}
		int rootval = postorder[postend];
		TreeNode root = new TreeNode(rootval);
		
		int k = 0;
		for(int i = 0; i < inorder.length; ++i){
			if(inorder[i] == rootval){
				k = i;
				break;
			}
		}
		root.left = helper(inorder,postorder,instart, k-1, poststart,poststart+k-(instart+1));
		root.right = helper(inorder, postorder,k+1, inend, poststart+k-instart, postend-1);
		return root;
	}
    
}
