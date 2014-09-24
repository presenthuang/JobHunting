package linkedList;


//see PartitonList.java
public class LinkedLists2_04 {
//Write code to partition a linked list around a value x, 
//	such that all nodes less than x come before all nodes greater than or equal to x.
	public LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode fakeNode1 = new LinkedListNode(0);
		LinkedListNode fakeNode2 = new LinkedListNode(0);
		
		fakeNode1.next = node;
		LinkedListNode q = fakeNode2;
		LinkedListNode p = node;
		LinkedListNode pre = fakeNode1;
		while(p != null){
			if(p.val < x){
				p = p.next;
				pre = pre.next;
			}else{
				pre.next = p.next;
				q.next = p;
				q = q.next;
				p = pre.next;
			}
		}
		q.next = null;
		pre.next = fakeNode2.next;
		
		return fakeNode1.next;
	}
	
}
