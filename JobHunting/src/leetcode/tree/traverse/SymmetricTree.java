package leetcode.tree.traverse;

import utils.TreeNode;

public class SymmetricTree {
//	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//	For example, this binary tree is symmetric:
//
//	    1
//	   / \
//	  2   2
//	 / \ / \
//	3  4 4  3
//	But the following is not:
//	    1
//	   / \
//	  2   2
//	   \   \
//	   3    3
//	Note:
//	Bonus points if you could solve it both recursively and iteratively.
	
//	http://gongxuns.blogspot.com/2012/12/leetcodesymmetric-tree.html
	
	//recursive
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSym(root.left, root.right);
    }
    private boolean isSym(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSym(left.left, right.right) && isSym(left.right, right.left);
        
    }
    
    //iterative
//    public boolean isSymmetric(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(root==null) return true;
//        LinkedList<TreeNode> l = new LinkedList<TreeNode>(),
//                            r = new LinkedList<TreeNode>();
//        l.add(root.left);
//        r.add(root.right);
//        while(!l.isEmpty() && !r.isEmpty()){
//            TreeNode temp1=l.poll(),
//                     temp2=r.poll();
//            if(temp1==null && temp2!=null || temp1!=null && temp2==null)
//                return false;
//            if(temp1!=null){
//                if(temp1.val!=temp2.val) return false;
//                l.add(temp1.left);
//                l.add(temp1.right);
//                r.add(temp2.right);
//                r.add(temp2.left);
//            }
//        }
//        return true;
//    }
}
