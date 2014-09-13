package edu.columbia.xh2211.leetcode;

import java.util.List;

public class MergekSortedLists {
//	Merge k sorted linked lists and return it as one sorted list. 
//	Analyze and describe its complexity.

	/**
     * Definition for singly-linked list.
     */
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode mergeKLists(List<ListNode> lists) {
    	ListNode new_list = null;
        for(ListNode list : lists){
        	 new_list = mergeList(new_list,list);
        }
        return new_list;
    }
    
    public ListNode mergeList(ListNode list1, ListNode list2){
    	if(list1 == null) return list2;
    	if(list2 == null) return list1;
    	if(list1.val < list2.val){
    		list1.next = mergeList(list1.next, list2);
    		return list1;
    	}else{
    		list2.next = mergeList(list2.next, list1);
    		return list2;
    	}
    }
}
