package leetcode.problems;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class _450_DeleteNodeIInBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(30);
		root.right.right.left = new TreeNode(25);
		root.right.right.right = new TreeNode(36);

		System.out.println(deleteNode(root, 20).val);
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;

		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			TreeNode node = findMin(root.right);
			root.val = node.val;
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}

	public static TreeNode findMin(TreeNode node) {
		while (node.left != null)
			node = node.left;

		return node;
	}


	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
