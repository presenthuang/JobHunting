package leetcode.linkedList;

import utils.ListNode;

public class ReorderList {
	// ================================================================== //
	// Reorder List
	// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	//
	// You must do this in-place without altering the nodes' values.
	//
	// For example,
	// Given {1,2,3,4}, reorder it to {1,4,2,3}.
	// ================================================================== //
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		//first we should find the middle of this linkedlist using two pointers.
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode q = slow.next;
		//We need to reverse from the slow.next to the end of the list.
		while (q.next != null) {
			ListNode temp = slow.next;
			slow.next = q.next;
			q.next = q.next.next;
			slow.next.next = temp;
		}
		q = head;
		// then start from the head and the mid+1, iteratively through all the nodes and combine them.
		while (slow != q && slow.next != null) {
			ListNode temp = q.next;
			q.next = slow.next;
			slow.next = slow.next.next;
			q.next.next = temp;
			q = q.next.next;
		}
	}
}
