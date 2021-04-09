package leetcode.problems;

/**
 * https://com/problems/minimum-depth-of-binary-tree/
 * 二叉树最小深度
 */
public class _111_MinimumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(0);

		System.out.println(minDepth(root));
	}

	public static int minDepth(TreeNode root) {
		//递归终止条件
		if (root == null) return 0;

		//左子树最小深度
		int left = minDepth(root.left);
		//右子树最小深度
		int right = minDepth(root.right);

		//如果左子树深度为0, 结果为right+1
		//如果右子树深度为0, 结果为left+1
		//否则结果为left和right中的较小者
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
