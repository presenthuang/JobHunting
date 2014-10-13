package linkedList;

public class PartitionList {
//	Given a linked list and a value x, 
//	partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//	You should preserve the original relative order of the nodes in each of the two partitions.
//
//	For example,
//	Given 1->4->3->2->5->2 and x = 3,
//	return 1->2->2->4->3->5.
	
//	one thing is to use 2 linked list to store both larger and smaller parts, then combine the two lists.
	 public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	public ListNode partition(ListNode head, int x) {
		if(head == null)
			return null;
		ListNode fakeNode1 = new ListNode(0);
		ListNode fakeNode2 = new ListNode(0);
		
		fakeNode1.next = head;
		ListNode p = head;
		ListNode prev = fakeNode1;
		ListNode p2 = fakeNode2;
		
		while(p != null){
			if(p.val < x){//if smaller than target, just jump to the next node.
				p = p.next;//move to next node.
				prev = prev.next;//move to next node 
			}else{//if larger than target, then swap.
				p2.next = p;//p2 next point to current
				prev.next = p.next;//prev jump to next node
				
				p = prev.next;//p equal next node
				p2 = p2.next;//p2 move next
			}
		}
		p2.next = null;
		prev.next = fakeNode2.next;
		
		return fakeNode1.next;
	}
}
