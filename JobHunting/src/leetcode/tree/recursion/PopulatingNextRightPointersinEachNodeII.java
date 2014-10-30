package leetcode.tree.recursion;

import utils.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {
//	Follow up for problem "Populating Next Right Pointers in Each Node".
//
//	What if the given tree could be any binary tree? Would your previous solution still work?
//
//	Note:
//
//	You may only use constant extra space.
//	For example,
//	Given the following binary tree,
//	         1
//	       /  \
//	      2    3
//	     / \    \
//	    4   5    7
//	After calling your function, the tree should look like:
//	         1 -> NULL
//	       /  \
//	      2 -> 3 -> NULL
//	     / \    \
//	    4-> 5 -> 7 -> NULL
	
//	http://blog.csdn.net/muscler/article/details/22907093
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        //如果右孩子不为空，左孩子的next是右孩子。  
        //反之，找root next的至少有一个孩子不为空的节点
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else{
                TreeLinkNode p = root.next;
                while(p != null && p.left == null && p.right == null){
                    p = p.next;
                }
                if(p != null){
                    root.left.next = p.left == null? p.right : p.left;
                }
            }
        }
        
        //右孩子的next 根节点至少有一个孩子不为空的next  
        if(root.right != null){
            TreeLinkNode p = root.next;
            while(p != null && p.left == null && p.right == null){
                    p = p.next;
                }
                if(p != null){
                    root.right.next = p.left == null? p.right : p.left;
                }
        }
        connect(root.right);
        connect(root.left);
    }
}
