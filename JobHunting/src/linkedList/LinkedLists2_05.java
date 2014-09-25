package linkedList;

import basic.LinkedListNode;


public class LinkedLists2_05 {
//You have two numbers represented by a linked list, where each node contains a 
//	single digit. The digits are stored in reverse order, such that the 1's digit is at the head 
//	of the list. Write a function that adds the two numbers and returns the sum as a linked list.
//	FOLLOW UP
//	Suppose the digits are stored in forward order. Repeat the above problem.
	
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
		if(l1 == null && l2 == null && carry == 0)//if all data are 0, then no node to be added
			return null;
		
		LinkedListNode result = new LinkedListNode(0);//create a new node.
		int val = carry;
		
		if(l1 != null){
			val += l1.val;
		}
		if(l2 != null){
			val += l2.val;
		}
		
		result.val = val % 10;//current node value
		
		if(l1 != null || l2 != null){//
			result.next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
		}
		return result;
	}
	
	//if the list is reversed
	public class PartialSum{
		public LinkedListNode sum = null;
		public int carry = 0;
	}
	
	LinkedListNode addListsReversed(LinkedListNode l1, LinkedListNode l2){
		int len1 = length(l1);
		int len2 = length(l2);
		
		if(len1 < len2){
			l1 = padList(l1,len2-len1);
		}else{
			l2 = padList(l2,len1-len2);
		}
		
		PartialSum sum = addListsHelper(l1,l2);
		
		if(sum.carry == 0){
			return sum.sum;
		}else{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	

	private LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for(int i = 0; i < padding; ++i){
			LinkedListNode n = new LinkedListNode(0);
			head.prev = n;
			n.next = head;
			head = n;
		}
		return head;
	}



	private LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if(list != null){
			list.prev = node;
			node.next = list;
		}
		return node;
	}



	private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		int val = sum.carry + l1.val + l2.val;
		
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}



	private int length(LinkedListNode list) {
		LinkedListNode p = list;
		int length = 0;
		while(p != null){
			p = p.next;
			length++;
		}
		return length;
	}
}
