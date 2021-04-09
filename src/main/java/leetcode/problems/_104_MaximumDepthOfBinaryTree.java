package leetcode.problems;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 二叉树最大深度
 */
public class _104_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(0);

		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		//递归终止条件
		if (root == null) return 0;

		//返回左子树和右子树中的较大者
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
