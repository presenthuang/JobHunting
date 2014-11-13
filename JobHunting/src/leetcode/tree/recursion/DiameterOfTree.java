package leetcode.tree.recursion;

import utils.TreeNode;

public class DiameterOfTree {
	static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;
		return getDiameter(root);
	}

	static int getDiameter(TreeNode root) {
		if (root == null)
			return 0;
		int rootDiameter = depth(root.left) + depth(root.right) + 1;
		int leftDiameter = getDiameter(root.left);
		int rightDiameter = getDiameter(root.right);

		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	static int depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		System.out.println(diameterOfTree(root));
	}

}
