package linkedList;

import utils.ListNode;

public class ReverseLinkedListII {
	// ================================================================== //
	// Reverse Linked List II
	// Reverse a linked list from position m to n. Do it in-place and in
	// one-pass.
	//
	// For example:
	// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	//
	// return 1->4->3->2->5->NULL.
	//
	// Note:
	// Given m, n satisfy the following condition:
	// 1 ≤ m ≤ n ≤ length of list.
	// ================================================================== //
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode begin = dummy;
		for (int i = 0; i < m; i++) {
			begin = begin.next;
		}
		ListNode iter = begin.next;
		int k = n - m;
		while (iter.next != null && k > 0) {
			ListNode temp = begin.next;
			begin.next = iter.next;
			iter.next = iter.next.next;
			begin.next.next = temp;
			k--;
		}
		return dummy.next;
	}
}
