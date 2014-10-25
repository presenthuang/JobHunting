package leetcode.linkedList;

import java.util.HashMap;

public class CopyListwithRandomPointer {
// ==================================================================  //  
//	Copy List with Random Pointer 
//A linked list is given such that each node contains 
//an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.
//==================================================================  //  
    class RandomListNode {
    	int label;
    	RandomListNode next, random;
    	RandomListNode(int x) { this.label = x; }
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
    	HashMap<Integer,RandomListNode> labels = new HashMap<>();
    	if(head == null){
        	return null;
        }
    	RandomListNode newhead = new RandomListNode(head.label);
    	labels.put(head.label,newhead);
    	RandomListNode p = newhead;
    	RandomListNode q = head;
    	while(q.next != null || q.random != null){
    		if(q.random != null){//insert in the node that has a random pointer.
    			if(labels.containsKey(q.random.label)){
    				p.random = labels.get(q.random.label);//if the node has already exist in the hashmap.
    			}else{//if not exist, just add the new node into the table.
    				RandomListNode temp = new RandomListNode(q.random.label);
    				p.random = temp;
    				labels.put(q.random.label, temp);
    			}
    		}
    		if(q.next != null){//add next node in the list.
        		if(labels.containsKey(q.next.label)){
        			p.next = labels.get(q.next.label);//already exist.
        		}else{
        			RandomListNode temp = new RandomListNode(q.next.label);
        			p.next = temp;
        			labels.put(q.next.label, temp);
        		}
    		}
    		if(q.next != null){
        		p = p.next;
        		q = q.next;
    		}else{//finished construction.
    		    break;
    		}
    	}
    	return newhead;
    }
}
