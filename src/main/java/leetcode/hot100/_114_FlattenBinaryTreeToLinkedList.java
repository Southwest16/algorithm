package leetcode.hot100;

/**
 * 二叉树展开为链表
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_FlattenBinaryTreeToLinkedList {
	private static TreeNode prev = null;

	public static void flatten(TreeNode root) {
		if (root == null) return;

		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		flatten(root);
	}
}
