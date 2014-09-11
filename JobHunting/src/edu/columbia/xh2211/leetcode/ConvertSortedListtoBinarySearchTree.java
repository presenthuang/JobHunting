package edu.columbia.xh2211.leetcode;

public class ConvertSortedListtoBinarySearchTree {
// ==================================================================  //  
//  Convert Sorted List to Binary Search Tree 
//  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//==================================================================  //  
    /**
     * Definition for singly-linked list.
     */
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
 	 /**
       * Definition for binary tree
       */
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
      
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
