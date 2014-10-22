package interviewQuestions;

import utils.LinkedListNode;

public class MergeTwoSortedList {
	LinkedListNode MergeLists(LinkedListNode list1, LinkedListNode list2) {
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  if (list1.val < list2.val) {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		  } else {
		    list2.next = MergeLists(list2.next, list1);
		    return list2;
		  }
		}
}
