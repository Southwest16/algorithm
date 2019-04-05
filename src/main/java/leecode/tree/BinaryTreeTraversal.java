package leecode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序、中序、后序遍历
 */
public class BinaryTreeTraversal {
    //preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);

            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return output;
    }

    // postorder traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);

            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return output;
    }

    //inorder traversal
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        //System.out.println(btt.postorderTraversal(root));
        //System.out.println(btt.preorderTraversal(root));
        System.out.println(btt.inorderTraversal(root));
    }

}
