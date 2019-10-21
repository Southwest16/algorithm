package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 二叉树层次遍历
 */
public class _102_BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		_102_BinaryTreeLevelOrderTraversal level = new _102_BinaryTreeLevelOrderTraversal();
		List<List<Integer>> result = level.levelOrder(root);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		//结果
		List<List<Integer>> result = new ArrayList<>();
		//判空
		if (root == null) return result;

		//存放每层结点的队列
		Deque<TreeNode> queue = new LinkedList<>();
		//将根结点先添加到队列中
		queue.add(root);

		//遍历队列中的元素
		while (!queue.isEmpty()) {
			//二叉树每层的结点个数
			int levelSize = queue.size();
			//临时存放每层结点值的列表
			List<Integer> currLevel = new ArrayList<>();

			//遍历当前层的结点, 同时把下面一层的结点添加到队列中
			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = queue.poll();
				currLevel.add(curr.val);

				if (curr.left != null) queue.add(curr.left);
				if (curr.right != null) queue.add(curr.right);
			}
			//每遍历完一层结点, 就把当前层结点值添加到最终的结果列表中
			result.add(currLevel);
		}
		return result;
	}
}