package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 72 : 二叉树的镜像
 * <p>
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树 
 *             8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *         镜像二叉树
 *             8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 * <p>
 * 示例1:
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：{8,10,6,11,9,7,5}
 */
public class NC_0072 {

    public static void main(String[] args) {
        NC_0072 nc0072 = new NC_0072();

        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);

        TreeNode node11 = new TreeNode(10);
        TreeNode node22 = new TreeNode(9);
        TreeNode node33 = new TreeNode(11);

        root.left = node1;
        root.right = node11;

        node1.left = node2;
        node1.right = node3;

        node11.left = node22;
        node11.right = node33;

        nc0072.print(root);
        System.out.println();
        TreeNode mirror = nc0072.Mirror(root);
        nc0072.print(mirror);
    }

    public void print(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            print(root.right);
        }
    }

    /**
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (null == pRoot) {
            return null;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        mid(pRoot);
        return pRoot;
    }

    public void mid(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode tempNoe = root.left;
        root.left = root.right;
        root.right = tempNoe;
        mid(root.left);
        mid(root.right);
    }
    
/*
    public void mid(TreeNode src, TreeNode target) {
        if (src.left != null) {
            if (target.right == null) {
                target.right = new TreeNode(0);
            }
            mid(src.left, target.right);
        }
        target.val = src.val;
        if (src.right != null) {
            if (target.left == null) {
                target.left = new TreeNode(0);
            }
            mid(src.right, target.left);
        }
    }
*/


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
