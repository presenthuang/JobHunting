package tree.search;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class UniqueBinarySearchTreesII {
//	Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//	For example,
//	Given n = 3, your program should return all 5 unique BST's shown below.
//
//	   1         3     3      2      1
//	    \       /     /      / \      \
//	     3     2     1      1   3      2
//	    /     /       \                 \
//	   2     1         2                 3
	
//	http://blog.csdn.net/linhuanmars/article/details/24761437
	    public List<TreeNode> generateTrees(int n) {
	        return helper(1,n);
	    }
		private ArrayList<TreeNode> helper(int left, int right) {
			ArrayList<TreeNode> res = new ArrayList<TreeNode>();
			if(left > right){
				res.add(null);
				return res;
			}
			for(int i = left; i <= right; ++i){
				ArrayList<TreeNode> leftTree = helper(left, i-1);
				ArrayList<TreeNode> rightTree = helper(i+1, right);
				for(int j = 0; j < leftTree.size(); ++j){
					for(int k = 0; k < rightTree.size(); ++k){
						TreeNode root = new TreeNode(i);
						root.left = leftTree.get(j);
						root.right = rightTree.get(k);
						res.add(root);
					}
				}
			}
			return res;
		}
}
