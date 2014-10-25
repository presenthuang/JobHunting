package leetcode.linkedList;

import utils.ListNode;

public class AddTwoNumbers {
//	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//			Output: 7 -> 0 -> 8
	
//	Beware of the border situation! Too many thinks to take care of so just keep in mind 
//	use the elegant recursive method
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        boolean inc = false;
        
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        
        while(h1 != null && h2 != null){
        	int val = h1.val + h2.val;
        	val = inc?val+1:val;
        	inc = false;
        	if(val >= 10){
        		inc = true;
        		val = val % 10;
        	}
        	p.next = new ListNode(val);
        	p = p.next;
        	h1=h1.next;
        	h2=h2.next;
        }
        
        if(h1 != null){
        	if(!inc){
        	    p.next = h1;
        	}else{
        	    while(h1 != null){
        	        if(inc){
        	            h1.val =h1.val+1;
        	        }
        	        inc = false;
        	        if(h1.val >= 10){
        	            inc = true;
        	            h1.val = h1.val % 10;
        	        }
        	        p.next = new ListNode(h1.val);
        	        p = p.next;
        	        h1 = h1.next;
        	    }
        	}
        }
        
        if(h2 != null){
        	if(!inc){
        	    p.next = h2;
        	}else{
        	    while(h2 != null){
        	        if(inc){
        	            h2.val =h2.val+1;
        	        }
        	        inc = false;
        	        if(h2.val >= 10){
        	            inc = true;
        	            h2.val = h2.val % 10;
        	        }
        	        p.next = new ListNode(h2.val);
        	        p = p.next;
        	        h2 = h2.next;
        	    }
        	}
        }
        if(h1 == null && h2 == null && inc){
        	p.next = new ListNode(1);
        }
        return newHead.next;
    }
}
