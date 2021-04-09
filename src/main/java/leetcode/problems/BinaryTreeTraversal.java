package leetcode.problems;

import java.util.LinkedList;

public class BinaryTreeTraversal {
	private static LinkedList<Integer> result = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);

		root.right = new TreeNode(12);
		root.right.right = new TreeNode(15);

		//System.out.println(btt.postorderTraversal(root));
		//System.out.println(btt.preorderTraversal(root));
		//System.out.println(btt.inorderTraversal(root));

		preOrder(root);
		//btt.preOrder(root);
		//btt.postOrder(root);
		System.out.println(result);
		//[4, 2, 5, 1, 3, 6]
		//[1, 2, 4, 5, 3, 6]
		//[4, 5, 2, 6, 3, 1]
	}

	public static void preOrder(TreeNode root) {
		if (root == null) return;

		result.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(TreeNode root) {
		if (root == null) return;

		inOrder(root.left);
		result.add(root.val);
		inOrder(root.right);
	}

	public static void postOrder(TreeNode root) {
		if (root == null) return;

		postOrder(root.left);
		postOrder(root.right);
		result.add(root.val);
	}
}
