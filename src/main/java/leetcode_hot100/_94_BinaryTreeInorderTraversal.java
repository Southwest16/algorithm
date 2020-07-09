package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class _94_BinaryTreeInorderTraversal {
	//方式一：递归
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
	}

	public void helper(TreeNode root, List<Integer> result) {
		if (root == null) return;
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}

	//方法二：使用Stack
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			//最左叉树上的节点依次放入stack
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			//从叶子节点依次出栈
			curr = stack.pop();
			result.add(curr.val);
			curr = curr.right;
		}
		return result;
	}

}
