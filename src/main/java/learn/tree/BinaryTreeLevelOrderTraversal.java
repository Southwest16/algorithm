package learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 二叉树按层遍历
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal level = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = level.bfs(t);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> bfs(TreeNode root) {
        //根节点判空
        if (root == null) return new ArrayList<>();

        //存放结果的列表
        List<List<Integer>> result = new ArrayList<>();
        //构建一个存放每层节点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点添加到队列中
        queue.add(root);

        //队列不为空就一直循环
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            //存放当前层的节点
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                //出队
                TreeNode currentNode = queue.poll();
                //保存出队节点的值
                currentLevel.add(currentNode.val);
                //如果左节点不为null, 就添加到队列中
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                //如果右节点不为null, 就添加到队列中
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            //把当前层所有元素添加到结果列表中
            result.add(currentLevel);
        }
        return result;
    }
}
