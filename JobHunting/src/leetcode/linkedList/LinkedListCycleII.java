package leetcode.linkedList;

import utils.ListNode;

public class LinkedListCycleII {
//	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//			Follow up:
//			Can you solve it without using extra space?
	
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null)
            return null;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast.next == null || fast.next.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
