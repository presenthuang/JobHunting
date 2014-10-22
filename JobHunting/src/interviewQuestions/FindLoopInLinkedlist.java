package interviewQuestions;

import utils.LinkedListNode;

public class FindLoopInLinkedlist {
	boolean hasLoop(LinkedListNode first) {
	    if(first == null) // list does not exist..so no loop either.
	        return false;
	    LinkedListNode slow, fast; // create two references.
	    slow = fast = first; // make both refer to the start of the list.
	    while(true) {
	        slow = slow.next;          // 1 hop.
	        if(fast.next != null)
	            fast = fast.next.next; // 2 hops.
	        else
	            return false;          // next node null => no loop.
	        if(slow == null || fast == null) // if either hits null..no loop.
	            return false;
	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return true;
	    }
	}
}
