package leetcode.sort;

import utils.ListNode;

public class InsertionSortList {
//	Sort a linked list using insertion sort.
	
	
//	http://blog.csdn.net/linhuanmars/article/details/21144553
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            pre = helper;
            while(pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}
