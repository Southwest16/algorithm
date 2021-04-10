package leetcode.problems;

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
		root.left.left = new TreeNode(15);
		root.left.right = new TreeNode(7);

		List<List<Integer>> result = levelOrder(root);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 广度优先搜索(借助队列)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> bfs(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>(); //存放结果

		if (root == null) return result; //判空

		//存放每层结点的队列
		Deque<TreeNode> queue = new LinkedList<>();
		//先将根结点添加到队列中
		queue.add(root);

		//遍历队列中的元素
		while (!queue.isEmpty()) {
			List<Integer> currLevel = new ArrayList<>(); //临时存放每层结点值的列表

			int levelSize = queue.size(); //二叉树每层的结点个数
			for (int i = 0; i < levelSize; i++) { //遍历当前层的结点, 同时把下一层所有结点添加到队列queue中
				TreeNode curr = queue.poll(); //获取并移除队头元素
				currLevel.add(curr.val); //将移除元素的值添加到列表中

				//由于队列是先进先出, 所以是先添加左子节点, 后添加右子节点
				if (curr.left != null) queue.add(curr.left); //添加当前结点的左子节点
				if (curr.right != null) queue.add(curr.right); //添加当前结点的右子节点
			}

			result.add(currLevel); //每遍历完一层, 就把当前层结点值集合添加到result中
		}
		return result;
	}


	/**
	 * 深度优先搜索(递归)
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		dfs(result, root, 0);

		return result;
	}
	public static void dfs(List<List<Integer>> result, TreeNode node, int level) {
		if (node == null) return;

		//给result添加ArrayList, 目的是为了存放每层节点的值
		if (result.size() < level + 1) { //因为level初始值为0, 所以要加1
			result.add(new ArrayList<>());
		}

		result.get(level).add(node.val);

		dfs(result, node.left, level + 1);
		dfs(result, node.right, level + 1);
	}
}