package edu.columbia.xh2211.leetcode;

public class MergeTwoSortedLists {
//	Merge two sorted linked lists and return it as a new list. 
//	The new list should be made by splicing together the nodes of the first two lists.
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 val = x;
		 next = null;
		 }
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode fakehead = new ListNode(0);
        ListNode p = fakehead;
        
        while(h1 != null && h2 != null){
        	if(h1.val > h2.val){
        		p.next = h2;
        		p = p.next;
        		h2 = h2.next;
        	}else{
        		p.next = h1;
        		p = p.next;
        		h1 = h1.next;
        	}
        }
        
        if(h1 != null)
        	p.next = h1;
        if(h2 != null)
        	p.next = h2;
        
        return fakehead.next;
    }
}
