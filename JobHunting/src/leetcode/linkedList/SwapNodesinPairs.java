package leetcode.linkedList;

import utils.ListNode;

public class SwapNodesinPairs {
//	Given a linked list, swap every two adjacent nodes and return its head.
//
//			For example,
//			Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//			Your algorithm should use only constant space. 
//	You may not modify the values in the list, only nodes itself can be changed.
//	Be careful about the correctness of the pointer move, may need 2 or 3 nodes
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode fakeHead = new ListNode(0);
		ListNode node0 = fakeHead;
		ListNode node1 = head;
		ListNode node2 = head.next;
		
		while(true){
			node1.next = node2.next;
			node2.next = node1;
			node0.next = node2;
			if(node1.next == null || node1.next.next == null)
				break;
			node0 = node1;
			node1 = node1.next;
			node2 = node1.next;
		}
		return fakeHead.next;
	}
}
