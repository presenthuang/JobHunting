package tree.traverse;

public class RecoverBinarySearchTree {
// ==================================================================  //  
//	Recover Binary Search Tree
//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. 
//Could you devise a constant space solution?
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
    TreeNode p,q;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if(root == null)
        	return;
        getwrong(root);
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }
	private void getwrong(TreeNode root) {
		if(root == null)
			return;
		getwrong(root.left);
		if(pre != null && root.val < pre.val){
		    if(p == null){
			p = pre;
			q = root;
    		}else{
    			q = root;
    		}
		}
		pre = root;
		getwrong(root.right);
	}
}
