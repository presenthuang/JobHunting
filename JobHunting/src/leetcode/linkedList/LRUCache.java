package leetcode.linkedList;

import java.util.HashMap;

public class LRUCache {
// ==================================================================  //  
//	LRU Cache 
//Design and implement a data structure for Least Recently Used (LRU) cache. 
//It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key 
//if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. 
//When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
//==================================================================  //  
    	private HashMap<Integer,DoubleLinkedListNode> data;
    	private DoubleLinkedListNode head;
    	private DoubleLinkedListNode end;
    	private int capacity;
    	private int len;
        public LRUCache(int capacity) {
        	this.capacity = capacity;
        	len = 0;
        	data = new HashMap<>();
        }
        
        public int get(int key) {
        	if(data.containsKey(key)){
        		DoubleLinkedListNode latest = data.get(key);
        		removeNode(latest);
        		setHead(latest);
        		return latest.val;
        	}else{
        		return -1;
        	}
        }
        
        private void setHead(DoubleLinkedListNode node) {
			node.next = head;
			node.pre = null;
			if(head != null){
				head.pre = node;
			}
			head=node;
			if(end==null){
				end = node;
			}
		}

		private void removeNode(DoubleLinkedListNode node) {
			DoubleLinkedListNode cur = node;
			DoubleLinkedListNode pre = cur.pre;
			DoubleLinkedListNode nex = cur.next;
			if(pre!=null){
				pre.next = nex;
			}else{
				head = nex;
			}
			if(nex != null){
				nex.pre = pre;
			}else{
				end = pre;
			}
		}

		public void set(int key, int value) {
        	if(data.containsKey(key)){
        		DoubleLinkedListNode oldNode = data.get(key);
        		oldNode.val = value;
        		removeNode(oldNode);
        		setHead(oldNode);
        	}else{
        		DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
        		if(len < capacity){
        			setHead(newNode);
        			data.put(key, newNode);
        			len++;
        		}else{
        			data.remove(end.key);
        			end = end.pre;
        			if(end!= null){
        				end.next = null;
        			}
        			setHead(newNode);
        			data.put(key, newNode);
        		}
        	}
        }
    }
    class DoubleLinkedListNode {
    	public int val;
    	public int key;
    	public DoubleLinkedListNode pre;
    	public DoubleLinkedListNode next;
     
    	public DoubleLinkedListNode(int key, int value) {
    		val = value;
    		this.key = key;
    }
}
