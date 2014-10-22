package tree.search;

import utils.ListNode;
import utils.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
// ==================================================================  //  
//  Convert Sorted List to Binary Search Tree 
//  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//==================================================================  //  
	
	//Old method, use two pointer for iterations and build from top-down
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head==null)
//        	return null;
//    	ListNode fast=head, slow=head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        while(fast.next != null && fast.next.next != null){
//        	fast = fast.next.next;
//        	slow=slow.next;
//        	dummy = dummy.next;
//        }
//        TreeNode root = new TreeNode(slow.val);
//        root.right = sortedListToBST(slow.next);
//        dummy.next = null;
//        if(slow == head)
//        	head = null;
//        root.left = sortedListToBST(head);
//        return root;
//    }
	static ListNode h;
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	private TreeNode sortedListToBST(int start, int end) {
		if(start > end){
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(start, mid-1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid+1,end);
		root.left = left;
		root.right = right;
		return root;
	}

	private int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
		while(p != null){
			len++;
			p = p.next;
		}
		return len;
	}
	
	
}
