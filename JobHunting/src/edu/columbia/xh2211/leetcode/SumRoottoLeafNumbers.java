package edu.columbia.xh2211.leetcode;

public class SumRoottoLeafNumbers {
	// ================================================================== //
	// Sum Root to Leaf Numbers
	// Given a binary tree containing digits from 0-9 only, each root-to-leaf
	// path could represent a number.
	//
	// An example is the root-to-leaf path 1->2->3 which represents the number
	// 123.
	//
	// Find the total sum of all root-to-leaf numbers.
	//
	// For example,
	//
	// 1
	// / \
	// 2 3
	// The root-to-leaf path 1->2 represents the number 12.
	// The root-to-leaf path 1->3 represents the number 13.
	//
	// Return the sum = 12 + 13 = 25.
	// ================================================================== //
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		String init = "" + root.val;
		return sums(root.left, init) + sums(root.right, init);
	}

	public int sums(TreeNode root, String intermediate) {
		if (root == null) {
			if (intermediate == "") {
				return 0;
			} else {
				return Integer.parseInt(intermediate);
			}
		}
		String digit = intermediate + root.val;
		if (root.left != null && root.right != null) {
			return sums(root.left, digit) + sums(root.right, digit);
		}
		if (root.left != null && root.right == null) {
			return sums(root.left, digit);
		}
		if (root.left == null && root.right != null) {
			return sums(root.right, digit);
		}
		return Integer.parseInt(digit);
	}
}
