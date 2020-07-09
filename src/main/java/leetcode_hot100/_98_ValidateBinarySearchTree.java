package leetcode_hot100;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class _98_ValidateBinarySearchTree {
	//中序遍历
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		double inorder = -Double.MAX_VALUE;

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			//父子节点值做比较
			if (root.val <= inorder) return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}
}
