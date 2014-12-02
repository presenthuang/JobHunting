package leetcode.linkedList;

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
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        for(int i = 1; i < m; ++i){
            begin = begin.next;
            if(begin == null || begin.next == null){
                return head;
            }
        }
        int length = n - m;
        ListNode iter = begin.next;
        while(iter.next != null && length > 0){
            ListNode temp = begin.next;
            begin.next = iter.next;
            iter.next = iter.next.next;
            begin.next.next = temp;
            length--;
        }
        return dummy.next;
    }
}
