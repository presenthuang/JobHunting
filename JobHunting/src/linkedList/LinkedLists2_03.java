package linkedList;

import basic.LinkedListNode;


public class LinkedLists2_03 {
//Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
	public static boolean deleteNode(LinkedListNode n){
//		key idea:
//		Because that we can not get the last node of the current node, so we have to delete the next node.
		if(n == null || n.next == null)
			return false;
		LinkedListNode delete = n.next;
		LinkedListNode next = delete.next;
		n.val = delete.val;
		
		//delete the next node.
		n.next = next;
		return true;
	}
}
