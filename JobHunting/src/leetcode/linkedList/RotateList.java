package leetcode.linkedList;

import utils.ListNode;

public class RotateList {
//	Given a list, rotate the list to the right by k places, where k is non-negative.
//
//	For example:
//	Given 1->2->3->4->5->NULL and k = 2,
//	return 4->5->1->2->3->NULL.
	
//	http://blog.csdn.net/linhuanmars/article/details/21903027
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode end = head;
        int length = 0;
        while(end != null){
            end = end.next;
            length++;
        }
        n = n % length;
        end = head;
        int idx = 0;
        while(end != null && idx < n){
            end = end.next;
            idx++;
        }
        ListNode start = head;
        while(end.next != null){
            end = end.next;
            start = start.next;
        }
        end.next = head;
        ListNode newhead = start.next;
        start.next = null;
        return newhead;
    }
}
