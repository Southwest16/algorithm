package leetcode.hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层次遍历
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class _102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> bfs(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Deque<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			List<Integer> currLevel = new ArrayList<>();
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = queue.poll();
				currLevel.add(curr.val);

				if (curr.left!=null) queue.addLast(curr.left);
				if (curr.right!=null) queue.addLast(curr.right);
			}
			result.add(currLevel);
		}
		return result;
	}
}
