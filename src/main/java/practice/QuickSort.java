package practice;

public class QuickSort {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(0);

		System.out.println(sort(root));
	}

	public static int sort(TreeNode root) {
		if (root == null) return 0;

		int left = sort(root.left);
		int right = sort(root.right);

		return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
