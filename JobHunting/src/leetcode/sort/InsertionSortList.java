package leetcode.sort;

import utils.ListNode;

public class InsertionSortList {
//	Sort a linked list using insertion sort.
	
//	http://blog.csdn.net/linhuanmars/article/details/21144553
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fakeNode = new ListNode(0);
        ListNode cur = head;
        ListNode p = fakeNode;
        while(cur != null){
            ListNode next = cur.next;
            p = fakeNode;
            while(p.next != null && p.next.val <= cur.val){
                p = p.next;
            }
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return fakeNode.next;
        
    }
}
