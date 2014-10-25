package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
	
//	Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//	OJ's undirected graph serialization:
//	Nodes are labeled uniquely.
//
//	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//	The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//	Second node is labeled as 1. Connect node 1 to node 2.
//	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//	Visually, the graph looks like the following:
//
//	       1
//	      / \
//	     /   \
//	    0 --- 2
//	         / \
//	         \_/
	
//	http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
        	return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, newHead);
        
        while(!queue.isEmpty()){
        	UndirectedGraphNode current = queue.pop();
        	List<UndirectedGraphNode> currNeighbors = current.neighbors; 
        	for(UndirectedGraphNode Neighbor: currNeighbors){
        		if(!map.containsKey(Neighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(Neighbor.label);
                    map.put(Neighbor,copy);
                    map.get(current).neighbors.add(copy);
                    queue.add(Neighbor);
                }else{
                    map.get(current).neighbors.add(map.get(Neighbor));
                }
        	}
        }
        return newHead;
    }
}