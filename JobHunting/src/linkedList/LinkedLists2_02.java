package linkedList;

import basic.LinkedListNode;


public class LinkedLists2_02 {
//Implement an algorithm to find the kth to last element of a singly linked list
	
	//A: Don't return the element
	public static int nthToLast(LinkedListNode head, int k){
		if(head == null)
			return 0;
		int i = nthToLast(head.next, k) + 1;
		if(i == k)
			System.out.println(head.val);
		return i;
	}
	
	//C:Create a Wrapper Class
	public class IntWrapper{
		public int value = 0;
	}
	
	LinkedListNode nthToLastR2(LinkedListNode head, int k, IntWrapper i){
		if(head == null)
			return null;
		LinkedListNode node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		if(i.value == k)//W've found the kth element.
			return head;
		return node;
	}
	
	
	//iterative
	LinkedListNode nthToLastIterative(LinkedListNode head, int k){
		if(k <= 0)
			return null;
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		
		//Move p2 forward k nodes into the list
		for(int i = 0; i < k - 1; ++i){
			if(p2 == null)
				return null;
			p2 = p2.next;
		}
		if(p2 == null)
			return null;
		
		while(p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
}
