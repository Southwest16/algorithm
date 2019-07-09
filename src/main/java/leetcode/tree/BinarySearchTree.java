package leetcode.tree;

//二叉查找树
public class BinarySearchTree {
    private Node tree;

    //查找
    public Node find(int data) {
        Node p = tree;
        if (p.data > data) {    // 要查找的数据比当前节点小, 就遍历它的左子树
            p = p.left;
        } else if (p.data < data) { // 要查找的数据比当前节点大, 就遍历它的右子树
            p = p.right;
        } else {    // 要查找的数据等于当前节点, 直接返回当前节点
            return p;
        }
        return null;
    }

    //插入
    public void insert(int data) {
        if (tree == null) { // 如果树为null, 就新建一个Node实例
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.data > data) {    // 要插入数据比当前节点小
                if (p.left == null) {   // 如果当前节点的左子树为null, 就直接插入
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    //删除
    public void delete(int data) {
        Node p = null;  // p指向要删除的节点, 初始化指向根节点
        Node pp = null; // pp记录的是p的父节点

        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
            if (p == null) return;

            // 要删除的节点有两个子节点
            if (p.left != null && p.right != null) {
                Node minP = p.right;
                Node minPP = p;
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                p.data = minP.data;
                p = minP;
                pp = minPP;
            }

            Node child;
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }
            if (pp == null) {
                tree = child;
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }

        }
    }

    // 树的节点
    public static class Node {
        private int data;   // 节点中的数据
        private Node left;  // 当前节点的左子节点
        private Node right; // 当前节点的右子节点

        public Node (int data) {
            this.data = data;
        }
    }
}
