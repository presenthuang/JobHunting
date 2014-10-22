package tree.search;

import utils.ListNode;
import utils.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
// ==================================================================  //  
//  Convert Sorted List to Binary Search Tree 
//  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//==================================================================  //  
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        	return null;
    	ListNode fast=head, slow=head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(fast.next != null && fast.next.next != null){
        	fast = fast.next.next;
        	slow=slow.next;
        	dummy = dummy.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        dummy.next = null;
        if(slow == head)
        	head = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
