package leetcode.linkedList;

import utils.ListNode;

public class LinkedListCycle {
//	Given a linked list, determine if it has a cycle in it.
//
//	Follow up:
//	Can you solve it without using extra space?
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null)
            return false;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
