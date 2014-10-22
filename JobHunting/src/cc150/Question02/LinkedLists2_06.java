package cc150.Question02;

import utils.LinkedListNode;


public class LinkedLists2_06 {
//Given a circular linked list, implement an algorithm which returns the node at the 
//	beginning of the loop
	LinkedListNode FindBeginning(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		LinkedListNode p;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		p = head;
		while(p != head){
			p = p.next;
			fast = fast.next;
		}
		return p;
	}
}
