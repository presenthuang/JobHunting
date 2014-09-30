package cc150.Question04;

//import java.util.LinkedList;

public class TreesandGraphs4_02 {
//Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
	public enum State{
		Unvisited, Visited, Visiting;
	}
	
//	public static boolean search(Graph g, Node start, Node end){
//		LinkedList<Node> q = new LinkedList<>();
//		
//		for(Node u : g.getNodes()){
//			u.state = State.Unvisited;
//		}
//		start.state = State.Visiting;
//		q.add(start);
//		Node u;
//		while(!q.isEmpty()){
//			u = q.removeFirst();
//			if(u != null){
//				for(Node v : u.getAdjacent()){
//					if(v.state == State.Unvisited){
//						if(v == end){
//							return true;
//						}else{
//							v.state = State.Visiting;
//							q.add(v);
//						}
//					}
//				}
//				u.state = State.Visited;
//			}
//		}
//		return false;
//	}
}
