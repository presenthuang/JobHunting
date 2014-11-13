package interviewQuestions;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class HamilitonCycle {
	int noOfVertices;

	public boolean check(node root) {
		Stack<node> nodeStack = new Stack<>();
		nodeStack.add(root);
		root.setIsOnStack();
		while (!nodeStack.isEmpty()) { // O(V), where V is total number of vertices
			node currentNode = nodeStack.peek(); // 1
			System.out.println(currentNode.getLabel());
			for (Entry<node, Boolean> entry : (currentNode.getNeighbourList()).entrySet()) { // V
				node currentNeighbourer = entry.getKey();
				if (!currentNeighbourer.isOnStack()) { // 1
					if (!entry.getValue()) { // 1
						nodeStack.push(currentNeighbourer); // 1
						currentNeighbourer.setIsOnStack();
						break;
					}
				} else if (currentNeighbourer == root
						&& nodeStack.size() == noOfVertices) { // 1
					return true;
				}
			}
			if (currentNode == nodeStack.peek()) {
				System.out.println("No neighbourer added");
				for (Entry<node, Boolean> entry : currentNode.getNeighbourList().entrySet()) { // V
					currentNode.setNodeIsNotVisited(entry.getKey()); // 1
				}
				nodeStack.pop();
				currentNode.setIsNotOnStack();
				node nodeOnTop = nodeStack.peek();
				nodeOnTop.setNodeIsVisited(currentNode);
			} else {
				for (node node : nodeStack) {
					System.out.print(node.getLabel() + " ");
				}
				System.out.println("");
			}
		}
		return false;
	}

	class node {
		String label;
		Map<node, Boolean> neighborList;

		public String getLabel() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setNodeIsVisited(node currentNode) {
			// TODO Auto-generated method stub

		}

		public void setNodeIsNotVisited(node key) {
			// TODO Auto-generated method stub

		}

		public void setIsNotOnStack() {
			// TODO Auto-generated method stub

		}

		public void setIsOnStack() {
			// TODO Auto-generated method stub

		}

		public boolean isOnStack() {
			// TODO Auto-generated method stub
			return false;
		}

		public Map<node, Boolean> getNeighbourList() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
