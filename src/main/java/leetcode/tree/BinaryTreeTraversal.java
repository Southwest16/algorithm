package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序、中序、后序遍历
 */
public class BinaryTreeTraversal {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val); //放到链表的尾部

            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return output;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val); //放到链表的头部

            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return output;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        TreeNode curr = root;
        //遍历整个树
        while (curr != null || stack.size() > 0) {
            //达到curr节点的最左节点
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            //已经访问了当前节点和其左子树, 现在轮到右子树。
            curr = curr.right;
        }
        return output;
    }

    private static LinkedList<Integer> output = new LinkedList<>();

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        //System.out.println(root.val);
        output.add(root.val);

        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;

        output.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        output.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(12);
        root.right.right = new TreeNode(15);

        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        //System.out.println(btt.postorderTraversal(root));
        //System.out.println(btt.preorderTraversal(root));
        //System.out.println(btt.inorderTraversal(root));

        btt.inOrder(root);
        //btt.preOrder(root);
        //btt.postOrder(root);
        System.out.println(output);
        //[4, 2, 5, 1, 3, 6]
        //[1, 2, 4, 5, 3, 6]
        //[4, 5, 2, 6, 3, 1]
    }

}
