package tree.construct;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
//	Given preorder and inorder traversal of a tree, construct the binary tree.
//
//	Note:
//	You may assume that duplicates do not exist in the tree.
	
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int prestart = 0;
        int preend = preorder.length-1;
        int instart = 0;
        int inend = inorder.length-1;
        
        return helper(preorder,prestart,preend,inorder,instart,inend);
        
    }


	private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
		if(instart > inend || prestart > preend){
			return null;
		}
		int rootval = preorder[prestart];
		TreeNode root = new TreeNode(rootval);
		
		int k = 0;
		for(int i = 0; i < inorder.length; ++i){
			if(inorder[i] == rootval){
				k = i;
				break;
			}
		}
		
		root.left = helper(preorder,prestart+1,prestart+k-instart,inorder,instart,k-1);
		root.right = helper(preorder,prestart+k-instart+1,preend,inorder,k+1,inend);
		
		return null;
	}
}
