package interviewQuestions;

public class TrinaryTree {
	// Implement insert and delete in a tri-nary tree. A tri-nary tree is much
	// like a binary tree
	// but with three child nodes for each parent instead of two -- with the
	// left node being
	// values less than the parent, the right node values greater than the
	// parent, and the
	// middle nodes values equal to the parent.
	// For example, suppose I added the following nodes to the tree in this
	// order: 5, 4, 9, 5, 7, 2, 2. The resulting tree would look like this:
	// 5
	// /|\
	// 4 5 9
	// / /
	// 2 7
	// |
	// 2
	TrinaryNode root;

	/**
	 * Constructor
	 */
	public TrinaryTree() {
		this.root = null;
	}

	/**
	 * This is the interface of insert operation.
	 * @param val
	 */
	public void insert(int val){
		this.root = insert(val, this.root);
	}
	
	/**
	 * Iteratively call this function to insert the node until it reached to the
	 * correct position.
	 * 
	 * @param val
	 * @param node
	 * @return
	 */
	private TrinaryNode insert(int val, TrinaryNode node) {
		if (node == null) {
			node = new TrinaryNode(val);
		} else if (val < node.val) {
			node.left = insert(val, node.left);
		} else if (val == node.val) {
			node.middle = insert(val, node.middle);
		} else {
			node.right = insert(val, node.right);
		}
		return node;
	}

	/**
	 * This is an auxiliary function for delete operation. Find the smallest element rooted from the input node.
	 * @param node
	 * @return
	 */
	private TrinaryNode findMin(TrinaryNode node) {
		if (node != null) {
			while (node.left != null) {
				return findMin(node.left);
			}
		}
		return node;
	}

	/**
	 * This is the interface for delete Operation.
	 * @param val
	 */
	public void delete(int val){
		this.root = delete(val, this.root);
	}
	
	/**
	 * Delete in the tree with an input val.
	 * @param val
	 * @param node
	 * @return
	 */
	private TrinaryNode delete(int val, TrinaryNode node) {
		if (node == null) {
			throw new RuntimeException();
		} else if (val < node.val) {
			node.left = delete(val, node.left);
		} else if (val > node.val) {
			node.right = delete(val, node.right);
		} else {
			if (node.middle != null) {
				node.middle = delete(val, node.middle);
			} else if (node.right != null) {
				int min = findMin(node.right).val;
				node.val = min;
				node.right = delete(min, node.right);
			} else {
				node = node.left;
			}
		}
		return node;
	}

	/**
	 * Print the tree interface.
	 * @param root
	 */
	public void Print(){
		Print(this.root);
	}
	
	/**
	 * This is the print function.
	 * @param node
	 */
	private void Print(TrinaryNode node) {
		if (node != null) {
			System.out.println("Node value : " + node.val);
			Print(node.left);
			Print(node.middle);
			Print(node.right);
		}
	}
	
	public static void main(String[] args) {
		TrinaryTree tree = new TrinaryTree();
		tree.insert(4);
		tree.insert(6);
		tree.delete(4);
		tree.Print();
	}
}

/**
 * Node class, describe with how the trinary tree node works.
 * 
 * @author xiaohuang
 *
 */
class TrinaryNode {
	int val;
	TrinaryNode left;
	TrinaryNode middle;
	TrinaryNode right;

	public TrinaryNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.middle = null;
	}
}
