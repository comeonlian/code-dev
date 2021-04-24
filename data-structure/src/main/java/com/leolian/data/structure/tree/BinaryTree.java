package com.leolian.data.structure.tree;

/**
 * 二叉树
 */
public class BinaryTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (null != root) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (null != root) {
            root.midOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (null != root) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 前序遍历查找
     */
    public TreeNode preOrderSearch(int no) {
        if (null != root) {
            return root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 中序遍历查找
     */
    public TreeNode midOrderSearch(int no) {
        if (null != root) {
            return root.midOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 后序遍历查找
     */
    public TreeNode postOrderSearch(int no) {
        if (null != root) {
            return root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * @param no
     */
    public void delNode(int no) {
        if (null != root) {
            if (root.getId() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空，无法删除！！！");
        }
    }

}
