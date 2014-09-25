package linkedList;

import java.util.HashSet;
import java.util.Set;

import basic.LinkedListNode;

public class LinkedLists2_01 {
//Write code to remove duplicates from a unsorted linked list.
	
	//with space
	public static void deleteDups(LinkedListNode n){
		if(n == null || n.next == null)
			return;
		LinkedListNode p = null;
		Set<Integer> visited = new HashSet<>();
		visited.add(n.val);
		while(n != null){
			if(visited.contains(n.val)){
				p.next = n.next;
			}else{
				visited.add(n.val);
				p = n;
			}
			n = n.next;
		}
	}
	
	//nobuffer
	public static void deleteDupsNoBuffer(LinkedListNode n){
		if(n == null || n.next == null)
			return;
		LinkedListNode currentLinkedListNode = n;
		while(currentLinkedListNode != null){
			LinkedListNode runnerLinkedListNode = currentLinkedListNode;
			while (runnerLinkedListNode.next != null){
				if(runnerLinkedListNode.next.val == currentLinkedListNode.val){
					runnerLinkedListNode.next = runnerLinkedListNode.next.next;
				}else {
					runnerLinkedListNode = runnerLinkedListNode.next;
				}
			}
			currentLinkedListNode = currentLinkedListNode.next;
		}
	}
}
